package com.kotlin.base.rx

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.injection.component.ResultCode
import rx.Observable
import rx.functions.Func1

/**
 *
 *  Desc:  通用数据类型转换封装
 *
 * @author zhf QQ:578121695
 * @time 2018/10/25 17:36
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}