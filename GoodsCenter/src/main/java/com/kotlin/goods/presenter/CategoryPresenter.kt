package com.kotlin.goods.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.presenter.view.CategoryView
import com.kotlin.goods.service.CategoryService
import javax.inject.Inject

/**
 *
 *  Desc: 商品分类 Presenter
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:28
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService


    /*
        获取商品分类列表
     */
    fun getCategory(parentId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId).excute(object : BaseSubscriber<MutableList<Category>?>(mView) {
            override fun onNext(t: MutableList<Category>?) {
                mView.onGetCategoryResult(t)
            }
        }, lifecycleProvider)

    }

}
