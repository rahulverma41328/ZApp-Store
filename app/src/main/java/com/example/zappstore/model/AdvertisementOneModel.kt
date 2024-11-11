package com.example.zappstore.model

import com.example.zappstore.R

data class AdvertisementOneModel(
    val imgUrl: Int
)

fun getOneListItem() : List<AdvertisementOneModel>{
    return listOf(
        AdvertisementOneModel(R.drawable.adverstisement_one),
        AdvertisementOneModel(R.drawable.adverstisement_one),
        AdvertisementOneModel(R.drawable.adverstisement_one),
        AdvertisementOneModel(R.drawable.adverstisement_one),
    )
}

