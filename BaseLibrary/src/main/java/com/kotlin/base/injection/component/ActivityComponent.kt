package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import dagger.Component

/**
 *
 *  Desc: Activity级别Component
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 14:30
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity
}
