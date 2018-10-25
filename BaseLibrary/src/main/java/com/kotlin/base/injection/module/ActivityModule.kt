package com.kotlin.base.injection.module

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 *
 *  Desc: Activity级别Module
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 14:31
 */
@Module
class ActivityModule(private val activity: Activity) {

//    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}