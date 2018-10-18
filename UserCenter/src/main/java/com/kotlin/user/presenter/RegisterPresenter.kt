package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.user.presenter.view.RegisterView

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 14:54
 */
class RegisterPresenter:BasePresenter<RegisterView>() {
    fun register(mobile:String ,verifyCode:String){
        /**
         * 业务逻辑
         */
        mView.onRegisterResult(true)
    }
}