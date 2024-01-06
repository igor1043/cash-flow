package com.cashflow.com.cashflow.domain.model

import com.cashflow.com.cashflow.presentation.utils.date.Month
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement

data class MonthData(
    val month: Month,
    val values: Array<Double>,
)

