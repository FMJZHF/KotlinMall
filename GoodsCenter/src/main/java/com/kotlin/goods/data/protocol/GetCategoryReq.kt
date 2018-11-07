package com.kotlin.goods.data.protocol

/**
 *
 *  Desc: 获取分类列表请求，parentId为0是一级分类
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:38
 */
data class GetCategoryReq (val parentId: Int)
