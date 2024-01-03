package com.cashflow.com.cashflow.domain.repository

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity

interface FinancesRepository {
    suspend fun getExpense(internalId: Int): List<ExpensesEntity>
    suspend fun getRevenues(internalId: Int): List<RevenuesEntity>
}
