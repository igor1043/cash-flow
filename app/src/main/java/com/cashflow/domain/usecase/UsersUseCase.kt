package com.cashflow.com.cashflow.domain.usecase

import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.repository.UsersRepository
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val consumerUnit: UsersRepository,
) {
    suspend fun saveUser(usersEntity: UsersEntity) = consumerUnit.insertUser(usersEntity)
    suspend fun getUser(userId: Int) = consumerUnit.getUser(userId)
    suspend fun getListUsers() = consumerUnit.getListUsers()
}
