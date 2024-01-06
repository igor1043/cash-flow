package com.cashflow.com.cashflow.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.data.mapper.toUserDomain
import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.com.cashflow.domain.model.UserModel
import com.cashflow.com.cashflow.domain.usecase.FinancesUseCase
import com.cashflow.com.cashflow.domain.usecase.UsersUseCase
import com.cashflow.com.cashflow.presentation.utils.Event
import com.cashflow.com.cashflow.presentation.utils.date.Month
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userUseCase: UsersUseCase,
    private val financesUseCase: FinancesUseCase,
) : ViewModel() {

    private val _user = MutableLiveData<Event<UserModel>>()
    val user: LiveData<Event<UserModel>> = _user

    private val _lastMovements = MutableLiveData<Event<List<ExpenseModel>>>()
    val lastMovements: LiveData<Event<List<ExpenseModel>>> = _lastMovements

    private val _currentMonth = MutableLiveData<Event<Month>>()
    val currentMonth: LiveData<Event<Month>> = _currentMonth

    private val _currentYear = MutableLiveData<Event<Int>>()
    val currentYear: LiveData<Event<Int>> = _currentYear

    fun setCurrentMonth(month: Month) {
        _currentMonth.value = Event(month)
    }

    fun setCurrentYear(currentYear: Int) {
        _currentYear.value = Event(currentYear)
    }

    fun getCurrentYear(): Int {
        return currentYear.value?.peekContent() ?: 0
    }

    fun getUser() {
        CoroutineScope(Dispatchers.IO).launch {
            val getUser = userUseCase.getUser(1).toUserDomain()
            _user.postValue(Event(getUser))
        }
    }

    fun getMockLastMovements() {
        CoroutineScope(Dispatchers.IO).launch {
            val lastExpenses = financesUseCase.getLastExpenses(1)
            lastExpenses.sortedBy { it.date }
            _lastMovements.postValue(Event(lastExpenses))
        }
    }
}