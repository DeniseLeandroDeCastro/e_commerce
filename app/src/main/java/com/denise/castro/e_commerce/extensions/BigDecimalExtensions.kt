package com.denise.castro.e_commerce.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formatToBrazilianDefault() : String {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatter.format(this)
}