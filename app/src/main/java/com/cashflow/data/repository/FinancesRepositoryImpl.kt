package com.cashflow.com.cashflow.data.repository

import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import javax.inject.Inject

class FinancesRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : FinancesRepository {
    override suspend fun saveExpense(expensesEntity: ExpensesEntity) {
        return database.expensesDao.insert(expensesEntity)
    }
    override suspend fun saveExpenses(list: List<ExpensesEntity>) {
        return database.expensesDao.insertAll(list)
    }
    override suspend fun saveRevenues(list: List<RevenuesEntity>) {
        return database.revenuesDao.insertAll(list)
    }

    override suspend fun getExpense(internalId: Int): ExpensesEntity {
        return database.expensesDao.getExpense(internalId)
    }
    override suspend fun getExpenses(userId: Int): List<ExpensesEntity> {
        return database.expensesDao.getExpenses(userId)
    }
    override suspend fun getRecentExpenses(userId: Int): List<ExpensesEntity> {
        return database.expensesDao.getRecentExpenses(userId)
    }
    override suspend fun getExpensesForMonth(userId: Int, date: String): List<ExpensesEntity> {
        return database.expensesDao.getExpensesForMonth(userId, date)
    }
    override suspend fun getTotalExpensesForMonth(userId: Int, date: String): Int {
        return database.expensesDao.getTotalExpensesForMonth(userId, date)
    }
    override suspend fun getRevenues(internalId: Int): List<RevenuesEntity> {
        return database.revenuesDao.getRevenues(internalId)
    }
}
