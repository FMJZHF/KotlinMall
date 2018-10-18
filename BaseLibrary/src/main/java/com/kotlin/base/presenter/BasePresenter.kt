package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:13
 */
open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}