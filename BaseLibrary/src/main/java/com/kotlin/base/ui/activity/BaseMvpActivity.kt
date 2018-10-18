package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:59
 */
open class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity() ,BaseView{
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    lateinit var mPresenter: T
}