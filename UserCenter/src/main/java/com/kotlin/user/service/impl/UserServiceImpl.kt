package com.kotlin.user.service.impl

import com.kotlin.user.service.UserService
import rx.Observable

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 9:49
 */
class UserServiceImpl: UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return Observable.just(true)
    }
}