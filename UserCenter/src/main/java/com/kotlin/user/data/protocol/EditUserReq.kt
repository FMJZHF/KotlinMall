package com.kotlin.user.data.protocol

/**
 *
 *  Desc:  修改用户资料请求体
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 15:06
 */
data class EditUserReq(val userIcon: String, val userName: String, val gender: String, val sign: String)
