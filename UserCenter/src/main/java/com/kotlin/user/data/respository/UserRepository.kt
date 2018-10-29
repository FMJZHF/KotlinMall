package com.kotlin.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.LoginReq
import com.kotlin.user.data.protocol.RegisterReq
import com.kotlin.user.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 *
 *  Desc: 用户相关数据层
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 15:49
 */
class UserRepository @Inject constructor() {

    /**
     * 用户注册
     */
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, pwd, verifyCode))
    }

    /**
     * 用户登录
     */
    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(mobile, pwd, pushId))
    }
}