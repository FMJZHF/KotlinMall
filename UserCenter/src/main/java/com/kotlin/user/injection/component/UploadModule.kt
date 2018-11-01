package com.kotlin.user.injection.component

import com.kotlin.user.service.UploadService
import com.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 *
 *  Desc: 上传Module
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 10:52
 */
@Module
class UploadModule {
    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}