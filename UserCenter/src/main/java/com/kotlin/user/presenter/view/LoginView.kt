package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.user.data.protocol.UserInfo

/**
 *
 *  Desc: 用户登录 视图回调
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 16:48
 */
interface LoginView : BaseView {

    fun onLoginResult(result: UserInfo)
}