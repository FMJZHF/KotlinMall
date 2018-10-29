package com.kotlin.user.data.protocol

/**
 *
 *  Desc: 登录请求体
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 20:03
 */
data class LoginReq(val mobile:String, val pwd:String, val pushId:String)
