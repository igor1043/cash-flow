package com.cashflow.com.cashflow.presentation.utils.number

import java.text.DecimalFormat

fun decimalValue(number: Double): String {
    val df = DecimalFormat(",##0,00")
    val dx: String = df.format(number)

    return dx
}