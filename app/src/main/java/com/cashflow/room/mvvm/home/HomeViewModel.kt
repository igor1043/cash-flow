package com.cashflow.room.mvvm.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cashflow.room.mvvm.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {

    @Singleton
    val _successSendPoints = MutableLiveData<Event<Boolean>>()
    val successSendPoints: LiveData<Event<Boolean>> = _successSendPoints


   }