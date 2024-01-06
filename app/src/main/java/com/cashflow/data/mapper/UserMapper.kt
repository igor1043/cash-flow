package com.cashflow.com.cashflow.data.mapper

import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.model.UserModel


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
