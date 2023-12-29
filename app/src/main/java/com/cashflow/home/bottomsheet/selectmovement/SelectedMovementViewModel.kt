package com.cashflow.home.bottomsheet.selectmovement

import androidx.lifecycle.ViewModel
import com.cashflow.utils.movements.TypesMovements
import com.cashflow.utils.movements.getTypeMovements
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectedMovementViewModel @Inject constructor() : ViewModel(){

    fun getMovements(): List<TypesMovements> {
        return getTypeMovements()
    }
}
