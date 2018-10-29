package com.kotlin.user.data.protocol

/**
 *
 *  Desc: 忘记密码请求体
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 21:57
 */
data class ForgetPwdReq(val mobile:String, val verifyCode:String)
