package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 *
 *  Desc:  忘记密码 视图回调
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 21:35
 */
interface ForgetPwdView : BaseView {
    /**
     * 忘记密码回调
     */
    fun onForgetPwdResult(result: String)
}