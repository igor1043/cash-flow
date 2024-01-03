package com.cashflow.com.cashflow.data.mapper

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.model.MovementModel
import com.cashflow.com.cashflow.domain.model.UserModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories.Companion.getMovementsCategoriesById
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement.Companion.getStatusMovementById


fun UsersEntity.toUserDomain(): UserModel {
    return UserModel(
        name = nameUser,
        email = email,
        password = password
    )
}

fun UserModel.toUserDomain(): UsersEntity {
    return UsersEntity(
        nameUser = name,
        email = email,
        password = password
    )
}
