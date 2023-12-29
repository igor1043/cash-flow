package com.cashflow.home.bottomsheet.selectdateperiod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.utils.Event
import com.cashflow.utils.date.Month
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SelectedDatePeriodViewModel @Inject constructor(
) : ViewModel() {

    private val _selectMonth = MutableLiveData<Event<Month>>()
    val selectMonth: LiveData<Event<Month>> = _selectMonth

    private val _selectYear = MutableLiveData<Event<Int>>()
    val selectYear: LiveData<Event<Int>> = _selectYear

    fun setCurrentMonth(month: Month) {
        _selectMonth.value = Event(month)
    }

    fun setCurrentYear(currentYear: Int) {
        _selectYear.value = Event(currentYear)
    }

    fun getCurrentYear(): Int {
        return selectYear.value?.peekContent() ?: 0
    }

}