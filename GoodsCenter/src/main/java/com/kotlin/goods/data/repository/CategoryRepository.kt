package com.kotlin.goods.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.goods.data.api.CategoryApi
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

/**
 *
 *  Desc:  商品分类 数据层
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:37
 */
class CategoryRepository @Inject constructor() {
    /*
        获取商品分类
     */
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}