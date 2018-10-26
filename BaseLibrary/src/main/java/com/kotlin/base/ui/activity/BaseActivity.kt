package com.kotlin.base.ui.activity

import android.os.Bundle
import com.kotlin.base.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 *
 *  Desc:
 *
 * @author zhf QQ:578121695
 * @time 2018/10/18 10:58
 */
open class BaseActivity:RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this) // 入栈

    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)  // 出栈
    }

}