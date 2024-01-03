package com.cashflow.com.cashflow.data.repository

import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import javax.inject.Inject

class FinancesRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : FinancesRepository {
    override suspend fun getExpense(internalId: Int): List<ExpensesEntity> {
        return database.expensesDao.getExpense(internalId)
    }
    override suspend fun getRevenues(internalId: Int): List<RevenuesEntity> {
        return database.revenuesDao.getRevenues(internalId)
    }
}
