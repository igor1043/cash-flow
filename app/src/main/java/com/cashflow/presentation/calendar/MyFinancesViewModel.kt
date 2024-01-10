package com.cashflow.com.cashflow.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.com.cashflow.domain.model.RevenueModel
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import com.cashflow.com.cashflow.presentation.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyFinancesViewModel @Inject constructor(
    private val financesUseCase: FinancesUseCase,
) : ViewModel() {
    private val _listExpenses = MutableLiveData<Event<List<ExpenseModel>>>()
    val listExpenses: LiveData<Event<List<ExpenseModel>>> = _listExpenses

    private val _listRevenues = MutableLiveData<Event<List<RevenueModel>>>()
    val listRevenues: LiveData<Event<List<RevenueModel>>> = _listRevenues

    fun getExpensesByDate(year: Int, month: Int, dayOfMonth: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val formattedMonth = String.format("%02d", month)
            val formattedDay = String.format("%02d", dayOfMonth)
            val date = "$year-$formattedMonth-$formattedDay"
            val listExpenses = financesUseCase.getExpensesByDay(1, date)

            _listExpenses.postValue(Event(listExpenses))
        }
    }
    fun getRevenuesByDate(year: Int, month: Int, dayOfMonth: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val formattedMonth = String.format("%02d", month)
            val formattedDay = String.format("%02d", dayOfMonth)
            val date = "$year-$formattedMonth-$formattedDay"
            val listExpenses = financesUseCase.getRevenuesByDay(1, date)

            _listRevenues.postValue(Event(listExpenses))
        }
    }
}