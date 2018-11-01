package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.user.data.protocol.UserInfo

/**
 *
 *  Desc: 编辑用户资料 视图回调
 *
 * @author zhf QQ:578121695
 * @time 2018/10/30 10:24
 */
interface UserInfoView : BaseView {

    // 获取上传凭证回调
    fun onGetUploadTokenResult(result: String)

    // 编辑用户资料回调
    fun onEditUserResult(result: UserInfo)
}