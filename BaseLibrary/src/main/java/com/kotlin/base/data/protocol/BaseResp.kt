package com.kotlin.base.data.protocol

/**
 *
 *  Desc: 接收到服务器的响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 15:41
 */
data class BaseResp<out T>(val status: Int, val message: String, val data: T)
