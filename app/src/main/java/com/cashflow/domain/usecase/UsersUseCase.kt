package com.cashflow.com.cashflow.domain.usecase

import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import com.cashflow.com.cashflow.domain.repository.UsersRepository
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val consumerUnit: UsersRepository,
) {
    suspend fun getListUsers(internalId: Int) = consumerUnit.getListUsers(internalId)
}
