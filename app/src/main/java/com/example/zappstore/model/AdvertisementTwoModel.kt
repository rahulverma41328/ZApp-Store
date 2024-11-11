package com.example.zappstore.model

import com.example.zappstore.R

data class AdvertisementTwoModel(
    val imgUrl: Int
)

fun getTwoListItem() : List<AdvertisementTwoModel>{
    return listOf(
        AdvertisementTwoModel(R.drawable.advertisement_two),
        AdvertisementTwoModel(R.drawable.advertisement_two),
        AdvertisementTwoModel(R.drawable.advertisement_two),
        AdvertisementTwoModel(R.drawable.advertisement_two),
    )
}
