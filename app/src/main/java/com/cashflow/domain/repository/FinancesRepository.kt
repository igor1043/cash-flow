package com.cashflow.com.cashflow.domain.repository

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity

interface FinancesRepository {
    suspend fun saveExpense(expensesEntity: ExpensesEntity)
    suspend fun saveExpenses(list: List<ExpensesEntity>)
    suspend fun getExpense(internalId: Int): ExpensesEntity
    suspend fun getExpenses(userId: Int): List<ExpensesEntity>
    suspend fun getRecentExpenses(userId: Int): List<ExpensesEntity>
    suspend fun getRevenues(internalId: Int): List<RevenuesEntity>
}
