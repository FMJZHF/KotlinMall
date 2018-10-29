package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.convertBoolean
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.user.data.respository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 9:49
 */
class UserServiceImpl @Inject constructor() : UserService {

    // 延迟加载
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        // 添加dagger2 后 可使用   lateinit var  repository:UserRepository 替换
//        val repository = UserRepository()


        return repository.register(mobile, pwd, verifyCode)
                .convertBoolean()
//                .flatMap(BaseFuncBoolean())
    }
}