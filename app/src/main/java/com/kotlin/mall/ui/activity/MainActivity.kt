package com.kotlin.mall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

// 主界面
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavBar.checkCartBadge(10)
        mBottomNavBar.checkMsgBadge(false)

        initView()

    }

    private fun initView() {

        val  manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContaier,HomeFragment())
        manager.commit()
    }
}
