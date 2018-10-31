package com.kotlin.user.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.*
import dagger.Component

/**
 *
 *  Desc: 用户模块Component
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 10:51
 * Dagger2 注入之后 必须重新编译
 */

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {
    // 注册
    fun inject(activity: RegisterActivity)

    // 登录
    fun inject(activity: LoginActivity)

    // 忘记密码
    fun inject(activity: ForgetPwdActivity)

    // 重置密码
    fun inject(activity: ResetPwdActivity)

    // 个人信息
    fun inject(activity: UserInfoActivity)
}
