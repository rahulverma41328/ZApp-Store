package com.example.zappstore.model

data class User(
    val name: String,
    val email: String,
    val phoneNo: String,
    val role:String = "",
    val status: String = "unverified",
    val imagePath: String = ""
) {
    constructor() : this("", "","", "","")
}