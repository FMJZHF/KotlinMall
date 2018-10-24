package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 *
 *  Desc: 用户相关 接口
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 15:45
 */
interface UserApi {

    /**
     * 用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}