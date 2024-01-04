package com.cashflow.com.cashflow.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.R
import com.cashflow.com.cashflow.data.mapper.toUserDomain
import com.cashflow.com.cashflow.domain.model.MonthData
import com.cashflow.com.cashflow.domain.model.MovementModel
import com.cashflow.com.cashflow.domain.model.UserModel
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import com.cashflow.com.cashflow.domain.usecase.UsersUseCase
import com.cashflow.com.cashflow.presentation.utils.Event
import com.cashflow.com.cashflow.presentation.utils.date.Month
import com.raizen.acelera.core.presentation.viewstate.ViewState
import com.raizen.acelera.core.presentation.viewstate.showDataLoaded
import com.raizen.acelera.core.presentation.viewstate.showLoadingProgress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val financesUseCase: FinancesUseCase,
) : ViewModel() {
    private val _consumerLiveData = MutableLiveData<Event<List<MonthData>>>()
    val consumerLiveData: LiveData<Event<List<MonthData>>> = _consumerLiveData

    fun getMockLastMovements() {

        CoroutineScope(Dispatchers.IO).launch {
            val monthsOfYear = mutableListOf<MonthData>()
            Month.values().forEach {
                val formattedMonth = String.format("%02d", it.number)
                val value = financesUseCase.getTotalExpensesForMonth(1, "2023-${formattedMonth}")
                monthsOfYear.add(MonthData(it, arrayOf(value.toDouble()), R.color.red_500))
            }
            _consumerLiveData.postValue(Event(monthsOfYear))
        }
    }
}