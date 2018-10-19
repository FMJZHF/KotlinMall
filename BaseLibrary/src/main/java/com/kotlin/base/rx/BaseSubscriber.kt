package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/**
 *
 *  Desc:  Rx订阅者默认实现
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 10:09
 */
open class BaseSubscriber<T>: Subscriber<T>() {

    override fun onCompleted() {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
    }
}