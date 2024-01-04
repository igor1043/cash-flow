package com.raizen.acelera.core.presentation.viewstate

import kotlinx.coroutines.channels.Channel

suspend fun <T> Channel<ViewState<T>>.showError(title: String? = null, message: String? = null) {
    this.send(ViewState.Error(title, message))
}

suspend fun <T> Channel<ViewState<T>>.showDataLoaded(data: T) {
    this.send(ViewState.Success(data))
}

suspend fun <T> Channel<ViewState<T>>.showLoadingProgress() {
    this.send(ViewState.Loading)
}
