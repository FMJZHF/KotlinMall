package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 *
 *  Desc: 编辑用户资料Presenter
 *
 * @author zhf QQ:578121695
 * @time 2018/10/30 10:23
 */
class UserInfoPresenter @Inject constructor(): BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService
}