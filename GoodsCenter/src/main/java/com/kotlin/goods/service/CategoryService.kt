package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.Category
import rx.Observable

/**
 *
 *  Desc: 商品分类 业务层 接口
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:30
 */
interface CategoryService {

    /*
        获取分类
     */
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}
