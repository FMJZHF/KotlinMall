package com.kotlin.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlin.base.R


/**
 *
 *  Desc: Glide工具类
 *
 * @author zhf QQ:578121695
 * @time 2018/10/26 13:57
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply(RequestOptions().centerCrop()).into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply(RequestOptions().fitCenter()).into(imageView)
    }

    /*
        当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView) {
        var options = RequestOptions()
                .placeholder(R.drawable.default_loading)
                .error(R.drawable.default_loading)
                .centerCrop()
        Glide.with(context).load(url).apply(options).into(imageView)
    }
}
