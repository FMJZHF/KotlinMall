package com.kotlin.goods.data.protocol

/**
 *
 *  Desc: 商品SKU数据类
 *
 * @author zhf QQ:578121695
 * @time 2018/11/7 11:49
 */
data class GoodsSku(
        val id: Int,
        val skuTitle: String,//SKU标题
        val skuContent: List<String>//SKU内容
)
