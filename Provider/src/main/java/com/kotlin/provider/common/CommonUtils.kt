package com.kotlin.provider.common
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.router.RouterPath

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/11/2 17:22
 */

/*
    顶级函数，判断是否登录
 */
fun isLogined():Boolean{
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}

/*
    如果已经登录，进行传入的方法处理
    如果没有登录，进入登录界面
 */
fun afterLogin(method:()->Unit){
    if (isLogined()){
        method()
    }else{
        // 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}
