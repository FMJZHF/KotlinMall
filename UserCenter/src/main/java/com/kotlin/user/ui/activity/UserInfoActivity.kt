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
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.UserInfoPresenter
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.utils.UserPrefsUtils
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
    private var mLocalFileUrl: String? = null
    private var mRemoteFileUrl: String? = null

    // 用户头像
    private var mUserIcon: String? = null
    // 用户昵称
    private var mUserName: String? = null
    // 用户手机号
    private var mUserMobile: String? = null
    // 用户性别
    private var mUserGender: String? = null
    // 用户签名
    private var mUserSign: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        mTakePhoto = TakePhotoImpl(this, this)
        initView()
        initData()
        mTakePhoto.onCreate(savedInstanceState)
    }

    // 初始化视图
    private fun initView() {
        // 头像点击，进行更换头像
        mUserIconView.onClick {
            showAlertView()
        }

        // 保存修改的信息
        mHeaderBar.getRightView().onClick {
            // 头像
            val userIcon = mRemoteFileUrl!!
            // 昵称
            val userName = mUserNameEt.text?.toString() ?: ""
            // 性别
            val userGender = if (mGenderMaleRb.isChecked) "0" else "1"
            // 签名
            val userSign = mUserSignEt.text?.toString() ?: ""
            mPresenter.editUser(userIcon, userName, userGender, userSign)
        }
    }

    /*
          初始化数据
       */
    private fun initData() {
        mUserIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
        mUserName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        mUserMobile = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
        mUserGender = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
        mUserSign = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_SIGN)

        mRemoteFileUrl = mUserIcon
        if (mUserIcon != "") {
            GlideUtils.loadUrlImage(this, mUserIcon!!, mUserIconIv)
        }
        mUserNameEt.setText(mUserName)
        mUserMobileTv.text = mUserMobile

        if (mUserGender == "0") { // 男
            mGenderMaleRb.isChecked = true
        } else { // 女
            mGenderFemaleRb.isChecked = true
        }

        mUserSignEt.setText(mUserSign)

    }

    private fun showAlertView() {

        AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this,
                AlertView.Style.ActionSheet, object : OnItemClickListener {
            override fun onItemClick(o: Any?, position: Int) {
                // 启用图片压缩
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
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
        Log.d("TakePhoto - Success", "原始图片地址 -> " + result?.image?.originalPath)
        Log.d("TakePhoto - Success", "压缩图片地址 -> " + result?.image?.compressPath)
        // 记录压缩图片地址
        mLocalFileUrl = result?.image?.compressPath
        // 获取上传凭证
        mPresenter.getUploadToken()
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
        Log.d("TakePhoto - Fail", msg)
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
        mUploadManager.put(mLocalFileUrl, null, result, object : UpCompletionHandler {
            override fun complete(key: String?, info: ResponseInfo?, response: JSONObject) {
                // 上传完成后返回图片位置，并进行拼接，获取完整的七牛图片地址
                mRemoteFileUrl = BaseConstant.IMAGE_SERVER_ADDRESS + response?.get("hash")

                Log.d("test", mRemoteFileUrl)
                GlideUtils.loadUrlImage(this@UserInfoActivity, mRemoteFileUrl!!, mUserIconIv)
            }

        }, null)
    }

    //  编辑用户资料回调
    override fun onEditUserResult(result: UserInfo) {
        toast("修改成功")
        UserPrefsUtils.putUserInfo(result)
    }

}