package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *  Desc: Application级别Module
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 11:27
 */
@Module
class AppModule(private val context: BaseApplication){

    // 工厂方法
    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }
}