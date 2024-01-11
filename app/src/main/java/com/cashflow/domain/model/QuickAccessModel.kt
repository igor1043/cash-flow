package com.cashflow.com.cashflow.domain.model

import com.cashflow.R
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsExpensesCategories

data class QuickAccessModel(
    var id: IdQuickAccess,
    var name: String,
    var icon: Int

)

enum class IdQuickAccess(
) {
    MyExpenses,
    MyPlanning,
    Calendar,
    MyRevenues,
    MyCards,
}
