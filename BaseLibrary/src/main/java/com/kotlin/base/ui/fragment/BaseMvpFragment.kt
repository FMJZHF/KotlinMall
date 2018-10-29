package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 *
 *  Desc: Fragment基类，业务相关
 *
 * @author zhf QQ:578121695
 * @time 2018/10/25 17:58
 */
open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject // 标注属性
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    /**
     *   Dagger注册
     */
    protected abstract fun injectComponent()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    // 初始Activity Component
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
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
    override fun onError(text: String) {
        toast(text)
    }


}