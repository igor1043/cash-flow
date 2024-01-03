package com.cashflow.com.cashflow.presentation.registerMovement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.data.mapper.toListExpensesEntity
import com.cashflow.com.cashflow.data.mapper.toListRevenuesEntity
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import com.cashflow.com.cashflow.presentation.registerMovement.MockMovements.Companion.createListMovements
import com.cashflow.com.cashflow.presentation.utils.Event
import com.cashflow.com.cashflow.presentation.utils.date.Month
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
                useCase.saveExpenses(createListMovements().toListExpensesEntity())
            }
        }
    }

}