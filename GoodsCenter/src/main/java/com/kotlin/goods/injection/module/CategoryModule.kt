package com.kotlin.goods.injection.module

import com.kotlin.goods.service.CategoryService
import com.kotlin.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 *
 *  Desc: 商品分类Module
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:33
 */
@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
