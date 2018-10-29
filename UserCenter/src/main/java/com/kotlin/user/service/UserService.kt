package com.kotlin.user.service

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable


/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 17:07
 */
interface UserService {
    // 用户注册
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>

    //用户登录
    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo>

}