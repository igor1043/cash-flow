package com.cashflow.room

import javax.inject.Inject

class ExpensesUseCase @Inject constructor(
    private val consumerUnit: ExpensesRepository,
) {
    suspend fun getExpenses(internalId: Int) =
        consumerUnit.getExpense(internalId)
}
