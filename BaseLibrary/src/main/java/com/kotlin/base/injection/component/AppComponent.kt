package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 *  Desc:  Application级别Component
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 11:26
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context(): Context
}