package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 *
 *  Desc: 用户模块Module
 *
 * @author zhf QQ:578121695
 * @time 2018/10/24 10:43
 */
@Module
class UserModule {
    // 提供构造 Service 的方法
    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}