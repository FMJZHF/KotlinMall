package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ResetPwdView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 *
 *  Desc: 忘记密码Presenter
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 21:49
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService: UserService


    /*
        重置密码
     */
    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.resetPwd(mobile, pwd).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onResetPwdResult("重置密码成功")
            }
        }, lifecycleProvider)

    }

}
