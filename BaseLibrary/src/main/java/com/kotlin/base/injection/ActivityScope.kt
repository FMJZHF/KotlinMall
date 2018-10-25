package com.kotlin.base.injection

import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 *
 *  Desc: Activity级别 作用域
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 14:45
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope
