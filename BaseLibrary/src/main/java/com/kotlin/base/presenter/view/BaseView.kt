package com.kotlin.base.presenter.view

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:14
 */
interface BaseView {
    fun showLoading();
    fun hideLoading();
    fun onError(text: String);
}