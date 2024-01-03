package com.cashflow.com.cashflow.presentation.login

import androidx.lifecycle.ViewModel
import com.cashflow.com.cashflow.data.local.entity.UsersEntity
import com.cashflow.com.cashflow.domain.usecase.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: UsersUseCase,
) : ViewModel() {

    fun createUser() {
        CoroutineScope(Dispatchers.IO).launch {
            val getListUsers = useCase.getListUsers()
            if (getListUsers.isEmpty()) {
                useCase.saveUser(UsersEntity("Igor Vinicius", "teste@123", "1234"))
            }
        }
    }
}