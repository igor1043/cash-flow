package com.cashflow.com.cashflow.domain.repository

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity

interface FinancesRepository {
    suspend fun saveExpense(expensesEntity: ExpensesEntity)
    suspend fun saveExpenses(list: List<ExpensesEntity>)
    suspend fun getExpense(internalId: Int): ExpensesEntity
    suspend fun getExpenses(userId: Int): List<ExpensesEntity>
    suspend fun getRecentExpenses(userId: Int): List<ExpensesEntity>
    suspend fun getExpensesForMonth(userId: Int, date: String): List<ExpensesEntity>
    suspend fun getTotalExpensesForMonth(userId: Int, date: String): String
    suspend fun getRevenues(internalId: Int): List<RevenuesEntity>
}
