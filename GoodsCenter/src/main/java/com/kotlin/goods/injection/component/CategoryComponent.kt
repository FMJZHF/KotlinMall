package com.kotlin.goods.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.goods.injection.module.CategoryModule
import com.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

/**
 *
 *  Desc: 商品分类Component
 *
 * @author zhf QQ:578121695
 * @time 2018/11/6 16:33
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(CategoryModule::class))
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}