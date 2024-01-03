package com.cashflow.com.cashflow.domain.repository

import com.cashflow.com.cashflow.data.local.entity.UsersEntity

interface UsersRepository {
    suspend fun insertUser(usersEntity: UsersEntity)
    suspend fun getUser(userId: Int): UsersEntity
    suspend fun getListUsers(): List<UsersEntity>
}
