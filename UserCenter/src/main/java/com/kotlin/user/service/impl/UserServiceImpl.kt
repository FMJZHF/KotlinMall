package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import com.kotlin.user.data.respository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import rx.functions.Func1

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 9:49
 */
class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        val repository = UserRepository()


        // FuncX常用在map、flatMap中，将传过来的数值类型转化为另一种数值类型，“FuncX”中的“X”代表着多少个参数
        return repository.register(mobile, pwd, verifyCode).flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
            override fun call(t: BaseResp<String>): Observable<Boolean> {
                if (t.status != 0) {
                    // 请求失败，返回 状态码，错误信息
                    return Observable.error(BaseException(t.status, t.message))
                }
                return Observable.just(true) // 请求成功，返回true
            }

        })
    }
}