package com.cashflow.room.mvvm.home.modelview

data class MovementUiModel(
    var name: String = "",
    var typeMovement: String = "",
    var movement: String = "",
    var value: Double = 0.0,
    var date: String = "",
    var status: String = "",
)

