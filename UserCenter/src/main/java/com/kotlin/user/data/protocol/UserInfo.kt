package com.kotlin.user.data.protocol

/**
 *
 *  Desc: 用户实体类
 *
 * @author zhf QQ:578121695
 * @time 2018/10/29 19:57
 */
data class UserInfo(val id:String, // 用户ID
                    val userIcon:String,  // 用户头像
                    val userName:String, // 用户名称
                    val userGender:String, // 用户性别
                    val userMobile:String, // 用户手机号
                    val userSign:String) // 用户签名