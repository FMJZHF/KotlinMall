package com.kotlin.user.data.protocol

/**
 *
 *  Desc: 重围密码请求体
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 21:58
 */
data class ResetPwdReq(val mobile:String, val pwd:String)
