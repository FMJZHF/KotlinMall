package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 *
 *  Desc: MVP中P层 基类
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:13
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T

    // Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}