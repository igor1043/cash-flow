package com.cashflow.com.cashflow.domain.model

import com.cashflow.com.cashflow.presentation.utils.movements.MovementsRevenueCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement

data class RevenueModel(
    var category: MovementsRevenueCategories,
    var value: Double = 0.0,
    var date: String = "",
    var user: Int,
    var status: StatusMovement? = null,
)


