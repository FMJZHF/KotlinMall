package com.kotlin.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.R.id.mRegister
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    //  Dagger注册
    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {

        toast(result);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        mPresenter = RegisterPresenter()
//        mPresenter.mView = this

        mRegister.onClick {
            var mobile = mMobileEt.text.toString();
            var pwd = mPwdEt.text.toString();
            var verifyCode = mVerifyCodeEt.text.toString();

            mPresenter.register(mobile, pwd, verifyCode)
        }


    }

}
