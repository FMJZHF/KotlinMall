package com.kotlin.base.common

import android.app.Application
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

/**
 *
 *  Desc: Application 基类
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 11:29
 */
class BaseApplication :Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

    }

    /**
     * Application Component初始化
     */
    private fun initAppInjection() {

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}