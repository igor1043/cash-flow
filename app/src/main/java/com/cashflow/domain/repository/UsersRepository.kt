package com.cashflow.com.cashflow.domain.repository

import com.cashflow.com.cashflow.data.local.entity.UsersEntity

interface UsersRepository {
    suspend fun getListUsers(internalId: Int): List<UsersEntity>
}
