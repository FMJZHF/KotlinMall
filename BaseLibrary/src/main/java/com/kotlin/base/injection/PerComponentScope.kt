package com.kotlin.base.injection

import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import javax.inject.Scope

/**
 *
 *  Desc: 组件级别 作用域
 *
 * @author zhf QQ:578121695
 * @time 2018/10/25 12:01
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope
