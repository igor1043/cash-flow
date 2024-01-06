package com.cashflow.com.cashflow.domain.usecase

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import com.cashflow.com.cashflow.data.mapper.toListExpensesModel
import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import javax.inject.Inject

class FinancesUseCase @Inject constructor(
    private val consumerUnit: FinancesRepository,
) {
    suspend fun saveExpense(expensesEntity: ExpensesEntity) = consumerUnit.saveExpense(expensesEntity)
    suspend fun saveExpenses(list: List<ExpensesEntity>) = consumerUnit.saveExpenses(list)
    suspend fun saveRevenue(list: List<RevenuesEntity>) = consumerUnit.saveRevenues(list)
    suspend fun getExpense(internalId: Int) = consumerUnit.getExpense(internalId)
    suspend fun getExpenses(userId: Int) = consumerUnit.getExpenses(userId)
    suspend fun getRecentExpenses(userId: Int) = consumerUnit.getRecentExpenses(userId)
    suspend fun getRevenues(internalId: Int) = consumerUnit.getRevenues(internalId)

    suspend fun getLastExpenses(internalId: Int) = consumerUnit.getRecentExpenses(internalId).toListExpensesModel()
    suspend fun getExpensesForMonth(userId: Int,date: String) = consumerUnit.getExpensesForMonth(userId, date).toListExpensesModel()
    suspend fun getTotalExpensesForMonth(userId: Int,date: String) = consumerUnit.getTotalExpensesForMonth(userId, date)

}
