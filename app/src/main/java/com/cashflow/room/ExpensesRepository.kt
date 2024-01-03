package com.cashflow.room

interface ExpensesRepository {
    suspend fun getExpense(internalId: Int): List<ExpensesEntity>
}
