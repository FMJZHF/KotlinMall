package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.Goods
import rx.Observable

/**
 *
 *  Desc: 商品 业务层 接口
 *
 * @author zhf QQ:578121695
 * @time 2018/11/7 11:50
 */
interface GoodsService {

    /*
        获取商品列表
     */
    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?>

    /*
        根据关键字查询商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?>

    /*
        获取商品详情
     */
    fun getGoodsDetail(goodsId: Int): Observable<Goods>
}
