package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 *
 *  Desc: 用户注册 视图回调
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 14:55
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)
}