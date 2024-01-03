package com.cashflow.com.cashflow.data.repository

import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : UsersRepository {
    override suspend fun getListUsers(internalId: Int): List<UsersEntity> {
        return database.usersDao.getUsers(internalId)
    }
}
