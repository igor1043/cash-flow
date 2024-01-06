package com.cashflow.com.cashflow.presentation.registerMovement

import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.data.mapper.toListExpenseEntity
import com.cashflow.com.cashflow.data.mapper.toListRevenueEntity
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterMovementViewModel @Inject constructor(
    private val useCase: FinancesUseCase,
) : ViewModel() {

    fun mockFinances() {
        CoroutineScope(Dispatchers.IO).launch {
            val totalExpenses = useCase.getExpenses(1)
            if (totalExpenses.isEmpty()) {
                useCase.saveExpenses(listExpenses().toListExpenseEntity())
                useCase.saveRevenue(listRevenue().toListRevenueEntity())
            }
        }
    }

}