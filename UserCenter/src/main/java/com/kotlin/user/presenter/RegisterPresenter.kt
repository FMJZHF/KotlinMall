package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 14:54
 */
//  @Inject constructor()  实例化的 构造函数
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var  userService:UserServiceImpl

    fun register(mobile: String, pwd: String, verifyCode: String) {
        /**
         * 业务逻辑
         */
        // 添加dagger2 后 可使用    lateinit var  userService:UserServiceImpl 替换
//        val userService = UserServiceImpl()
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        if(t)
                        mView.onRegisterResult("注册成功")
                    }
                },lifecycleProvider)
    }
}