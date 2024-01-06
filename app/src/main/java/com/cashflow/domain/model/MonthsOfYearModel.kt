package com.cashflow.com.cashflow.domain.model

import com.cashflow.com.cashflow.presentation.utils.date.Month

data class MonthData(
    val month: Month,
    val values: Array<Double>,
)

