package com.cashflow.com.cashflow.presentation.registerMovement

import com.cashflow.com.cashflow.domain.model.MovementModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement
import com.cashflow.com.cashflow.presentation.utils.movements.TypesMovements
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun createItemMovement(
    category: MovementsCategories,
    value: Double,
    date: String,
    user: Int,
    status: StatusMovement,
): MovementModel {
    return MovementModel(
        category,
        value,
        date,
        user,
        status,
    )
}

fun listMovements(): MutableList<MovementModel> {
    val list: MutableList<MovementModel> = mutableListOf()

    repeat(200) {
        val randomCategory = MovementsCategories.values().random()
        val isExpense = randomCategory.typeMovement == TypesMovements.EXPENSE
        val randomValue = if (isExpense) {
            -1 * (1..1000).random().toDouble() // Negative value for expense
        } else {
            (1..1000).random().toDouble() // Positive value for revenue
        }

        val randomDate = getRandomDateFormatted()

        val item = createItemMovement(
            randomCategory,
            randomValue,
            randomDate,
            1,
            if (isExpense) StatusMovement.PAID else StatusMovement.RECEIVED
        )

        list.add(item)
    }

    return list
}

fun getRandomDateFormatted(): String {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.YEAR, -1 * (0..365).random()) // Random date from the last year
    calendar.set(Calendar.HOUR_OF_DAY, (0..23).random())
    calendar.set(Calendar.MINUTE, (0..59).random())

    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(calendar.time)
}

abstract class MockMovements {

    companion object {
        @JvmStatic
        fun createListMovements(): MutableList<MovementModel> {
            return listMovements()
        }
    }
}