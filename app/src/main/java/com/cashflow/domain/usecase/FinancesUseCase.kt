package com.cashflow.com.cashflow.domain.usecase

import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import javax.inject.Inject

class FinancesUseCase @Inject constructor(
    private val consumerUnit: FinancesRepository,
) {
    suspend fun getExpenses(internalId: Int) = consumerUnit.getExpense(internalId)
    suspend fun getRevenues(internalId: Int) = consumerUnit.getRevenues(internalId)

}
