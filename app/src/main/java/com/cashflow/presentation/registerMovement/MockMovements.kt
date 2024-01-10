package com.cashflow.com.cashflow.presentation.registerMovement

import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.com.cashflow.domain.model.RevenueModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsExpensesCategories
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsRevenueCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun listExpenses(): MutableList<ExpenseModel> {
    val list: MutableList<ExpenseModel> = mutableListOf()

    repeat(2300) {
        val randomCategory = MovementsExpensesCategories.values().random()
        val randomValue =-1 * (1..1000).random().toDouble()

        val randomDate = getRandomDateFormatted()

        val item = ExpenseModel(
            randomCategory,
            randomValue,
            randomDate,
            1,
            StatusMovement.PAID
        )

        list.add(item)
    }

    return list
}

fun listRevenue(): MutableList<RevenueModel> {
    val list: MutableList<RevenueModel> = mutableListOf()

    repeat(2300) {
        val randomCategory = MovementsRevenueCategories.values().random()
        val randomValue =(250..1000).random().toDouble()

        val randomDate = getRandomDateFormatted()

        val item = RevenueModel(
            randomCategory,
            randomValue,
            randomDate,
            1,
            StatusMovement.RECEIVED
        )

        list.add(item)
    }

    return list
}

fun getRandomDateFormatted(): String {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, (2023..2024).random())
    calendar.set(Calendar.MONTH, (Calendar.JANUARY..Calendar.DECEMBER).random())
    val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, (1..maxDay).random())
    calendar.set(Calendar.HOUR_OF_DAY, (0..23).random())
    calendar.set(Calendar.MINUTE, (0..59).random())

    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(calendar.time)
}


