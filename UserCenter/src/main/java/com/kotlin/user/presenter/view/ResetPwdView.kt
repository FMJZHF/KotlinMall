package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 *
 *  Desc: 重置密码 视图回调
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 21:51
 */
interface ResetPwdView : BaseView {

    fun onResetPwdResult(result: String)
}
