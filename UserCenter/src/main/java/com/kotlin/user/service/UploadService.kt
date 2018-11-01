package com.kotlin.user.service

import rx.Observable

/**
 *
 *  Desc: 上传业务接口
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 10:53
 */
interface UploadService {

    fun getUploadToken(): Observable<String>

}