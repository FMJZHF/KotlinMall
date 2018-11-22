package com.kotlin.base.common

/**
 *
 *  Desc: 基础常量
 *
 * @author zhf QQ:578121695
 * @time 2018/10/19 14:30
 */
class BaseConstant {
    companion object {

        //七牛服务地址  TODO 试用期只有一个月，后期需要自己配置域名
        const val IMAGE_SERVER_ADDRESS = "http://phgasoa9a.bkt.clouddn.com/"

        //本地服务器地址
        const val SERVER_ADDRESS = "http://192.168.1.106:8080/kotlin/"

        //SP表名
        const val TABLE_PREFS = "Kotlin_mall"

        //Token Key
        const val KEY_SP_TOKEN = "token"

        const val isDebug = true

    }
}