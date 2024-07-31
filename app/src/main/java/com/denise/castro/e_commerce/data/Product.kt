package com.denise.castro.e_commerce.data

import android.os.Parcelable
import androidx.room.TypeConverters
import com.denise.castro.e_commerce.data.converter.Converters
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
@TypeConverters(Converters::class)
data class Product(
    val id: String,
    val name: String,
    val category: String,
    val price: Float,
    //val price: BigDecimal,
    val offerPercentage: Float? = null,
    val description: String? = null,
    val colors: List<Int>? = null,
    val sizes: List<String>? = null,
    val images: List<String>
): Parcelable {
    constructor(): this(
        "0",
        "",
        "",
        0f,
        //BigDecimal.ZERO,
        null,
        null,
        null,
        null,
        images = emptyList()
    )
}