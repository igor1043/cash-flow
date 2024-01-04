package com.raizen.acelera.core.presentation.viewstate

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<ViewState<T>>.showError(title: String? = null, message: String? = null) {
    this.value = ViewState.Error(title, message)
}

fun <T> MutableLiveData<ViewState<T>>.showDataLoaded(data: T) {
    this.value = ViewState.Success(data)
}

fun <T> MutableLiveData<ViewState<T>>.showLoadingProgress() {
    this.value = ViewState.Loading
}
