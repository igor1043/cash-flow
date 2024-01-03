package com.cashflow.com.cashflow.data.repository

import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : UsersRepository {
    override suspend fun insertUser(usersEntity: UsersEntity) {
        database.usersDao.insert(usersEntity)
    }
    override suspend fun getUser(userId: Int): UsersEntity {
        return database.usersDao.getUser(userId)
    }
    override suspend fun getListUsers(): List<UsersEntity> {
        return database.usersDao.getUsers()
    }
}
