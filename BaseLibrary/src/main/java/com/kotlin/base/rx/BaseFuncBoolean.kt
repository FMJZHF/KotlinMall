package com.kotlin.base.rx

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.injection.component.ResultCode
import rx.Observable
import rx.functions.Func1

/**
 *
 *  Desc: Boolean类型转换封装
 *
 * @author zhf QQ:578121695
 * @time 2018/10/25 17:29
 */
// FuncX常用在map、flatMap中，将传过来的数值类型转化为另一种数值类型，“FuncX”中的“X”代表着多少个参数
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {

    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS) {
            // 请求失败，返回 状态码，错误信息
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true) // 请求成功，返回true
    }
}