package com.kotlin.base.ui.activity

import android.os.Bundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

/**
 *
 *  Desc:  Activity基类，业务无关
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:59
 */
open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject // 标注属性
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    /**
     *   Dagger注册
     */
    protected abstract fun injectComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    // 初始Activity Component
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    /**
     * 显示加载框，默认实现
     */
    override fun showLoading() {

    }

    /**
     * 隐藏加载框，默认实现
     */
    override fun hideLoading() {

    }

    /**
     * 错误信息提示，默认实现
     */
    override fun onError() {

    }

}