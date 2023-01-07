package com.cashflow.room.mvvm.home.bottomsheet.selectmovement

import androidx.lifecycle.ViewModel
import com.cashflow.room.mvvm.utils.movements.TypesMovements
import com.cashflow.room.mvvm.utils.movements.getTypeMovements
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectedMovementViewModel @Inject constructor() : ViewModel(){

    fun getMovements(): List<TypesMovements> {
        return getTypeMovements()
    }
}
