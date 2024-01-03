package com.cashflow.com.cashflow.domain.model

import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement

data class UserModel(
    var name: String,
    var email: String,
    var password: String
)

