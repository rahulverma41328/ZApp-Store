package com.example.zappstore.model

import com.example.zappstore.R

data class HomeCategoriesModel(
    val imgUrl: Int,
    val title: String
)

fun getCategoriesListItem(): List<HomeCategoriesModel>{
    return listOf(
        HomeCategoriesModel(R.drawable.plumber_icon,"Plumber"),
        HomeCategoriesModel(R.drawable.plumber_icon,"Plumber"),
        HomeCategoriesModel(R.drawable.plumber_icon,"Plumber"),
    )
}