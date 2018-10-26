package com.kotlin.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 *
 *  Desc: 默认TextWatcher，空实现
 *  为了只重写一个方法 特添加此类
 *
 * @author zhf QQ:578121695
 * @time 2018/10/26 13:55
 */
open class DefaultTextWatcher: TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}
