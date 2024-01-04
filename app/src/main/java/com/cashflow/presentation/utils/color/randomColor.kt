package com.cashflow.com.cashflow.presentation.utils.color

import android.graphics.Color
import kotlin.random.Random

fun generateRandomColor(): Int {
    val random = Random.Default
    return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
}