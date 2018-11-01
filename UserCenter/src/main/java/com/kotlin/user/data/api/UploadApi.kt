package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 *
 *  Desc: 上传相关 接口
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 10:57
 */
interface UploadApi {

    /*
        获取七牛云上传凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}
