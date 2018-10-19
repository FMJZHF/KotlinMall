package com.kotlin.user.service

import rx.Observable


/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 17:07
 */
interface UserService {
    fun register (mobile:String,pwd:String,verifyCode:String): Observable<Boolean>
}