package com.kotlin.user.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.kotlin.base.utils.DateUtils
import android.view.View
import android.widget.AdapterView
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.utils.GlideUtils
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.UserInfoPresenter
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.presenter.view.UserInfoView
import com.qiniu.android.http.ResponseInfo
import com.qiniu.android.storage.UpCompletionHandler
import com.qiniu.android.storage.UploadManager
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import java.io.File

/**
 *
 *  Desc: 用户信息
 *
 * @author zhf QQ:578121695
 * @time 2018/10/30 9:32
 */
class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView, TakePhoto.TakeResultListener {

    private lateinit var mTakePhoto: TakePhoto

    private lateinit var mTempFile: File

    // 初始化 七牛文件上传管理器
    private val mUploadManager: UploadManager by lazy { UploadManager() }
    private var mLocalFileUrl:String? = null
    private var mRemoteFileUrl:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        mTakePhoto = TakePhotoImpl(this, this)
        initView()

        mTakePhoto.onCreate(savedInstanceState)
    }

    private fun initView() {
        mUserIconView.onClick {
            showAlertView()
        }
    }

    private fun showAlertView() {

        AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this,
                AlertView.Style.ActionSheet, object : OnItemClickListener {
            override fun onItemClick(o: Any?, position: Int) {
                // 启用图片压缩
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(),false)
                when (position) {
                    // 拍照
                    0 -> {
                        createTempFile()
                        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                    }
                    // 相册
                    1 -> mTakePhoto.onPickFromGallery()

                }
            }
        }).show()
    }

    // Dagger2 注册
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    // 获取图片
    override fun takeSuccess(result: TResult?) {
        Log.d("TakePhoto - Success","原始图片地址 -> "+ result?.image?.originalPath)
        Log.d("TakePhoto - Success","压缩图片地址 -> "+ result?.image?.compressPath)
        // 记录压缩图片地址
        mLocalFileUrl =  result?.image?.compressPath
        // 获取上传凭证
        mPresenter.getUploadToken()
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
        Log.d("TakePhoto - Fail",msg)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    // 创建临时文件
    fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        this.mTempFile = File(filesDir, tempFileName)
    }

    //  获取上传凭证回调
    override fun onGetUploadTokenResult(result: String) {
        // 使用七牛的SDK 上传图片
        mUploadManager.put(mLocalFileUrl,null,result,object: UpCompletionHandler {
            override fun complete(key: String?, info: ResponseInfo?, response: JSONObject) {
                // 上传完成后返回图片位置，并进行拼接，获取完整的七牛图片地址
                mRemoteFileUrl = BaseConstant.IMAGE_SERVER_ADDRESS + response?.get("hash")

                Log.d("test", mRemoteFileUrl)
                GlideUtils.loadUrlImage(this@UserInfoActivity, mRemoteFileUrl!!,mUserIconIv)
            }

        },null)
    }

    override fun onEditUserResult(result: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}