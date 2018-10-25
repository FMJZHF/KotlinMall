package com.kotlin.user.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
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
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}
