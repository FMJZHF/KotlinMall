package com.kotlin.user.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.user.data.respository.UploadRepository
import com.kotlin.user.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 *
 *  Desc: 上传业务实现类
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 10:54
 */
class  UploadServiceImpl @Inject constructor() : UploadService {
    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }
}