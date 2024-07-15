package com.denise.castro.e_commerce.data

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val imagePather: String = ""
) {
    constructor(): this("", "", "", "")
}
