package com.kotlin.user.data.protocol

/**
 *
 *  Desc: 注册请求体
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 15:47
 */
data class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String)