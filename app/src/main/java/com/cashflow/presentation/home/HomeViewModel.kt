package com.cashflow.com.cashflow.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import com.cashflow.com.cashflow.presentation.utils.Event
import com.cashflow.com.cashflow.presentation.utils.date.Month
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: FinancesUseCase,
) : ViewModel() {

    private val _currentMonth = MutableLiveData<Event<Month>>()
    val currentMonth: LiveData<Event<Month>> = _currentMonth

    private val _currentYear = MutableLiveData<Event<Int>>()
    val currentYear: LiveData<Event<Int>> = _currentYear

    fun setCurrentMonth(month: Month){
        _currentMonth.value = Event(month)
    }
    fun setCurrentYear(currentYear: Int){
        _currentYear.value = Event(currentYear)
    }
    fun getCurrentYear() : Int {
        return currentYear.value?.peekContent() ?: 0
    }

    fun teste() {
        CoroutineScope(Dispatchers.IO).launch {
            useCase.getExpenses(1)
        }
    }

}