package com.cashflow.room

import com.cashflow.dao.AppDatabase
import javax.inject.Inject

class ExpensesRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : ExpensesRepository {
    override suspend fun getExpense(internalId: Int): List<ExpensesEntity> {
        return database.expensesDao.getExpense(internalId)
    }
}
