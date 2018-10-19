package com.kotlin.base.ext
import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
/**
 *
 *  Desc: Kotlin通用扩展
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 10:18
 */


/*
    扩展Observable执行 方法
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
     this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}
