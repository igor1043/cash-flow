package com.cashflow.home.modelview

import com.cashflow.utils.movements.MovementsCategories
import com.cashflow.utils.movements.StatusMovement

data class MovementUiModel(
    var category: MovementsCategories,
    var value: Double = 0.0,
    var date: String = "",
    var status: StatusMovement? = null,
)

