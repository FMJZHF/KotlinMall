package com.kotlin.base.widgets

import android.content.Context
import android.widget.ImageView
import com.kotlin.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 *
 *  Desc: Banner图片加载器
 *
 * @author zhf QQ:578121695
 * @time 2018/11/1 16:57
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadUrlImage(context, path.toString(), imageView)
    }
}