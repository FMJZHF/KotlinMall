package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.LoginView
import com.kotlin.user.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 *
 *  Desc: 登录界面 Presenter
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 16:47
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
//    lateinit var userService: UserService
    lateinit var userService: UserServiceImpl

    /*
        登录
     */
    fun login(mobile: String, pwd: String, pushId: String) {

        // 判断网络是否可用
        if (!checkNetWork()) {
            return
        }
        // 显示加载框
        mView.showLoading()

        /**
         * 业务逻辑
         */
        userService.login(mobile, pwd, pushId).excute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
            }
        }, lifecycleProvider)
    }
}