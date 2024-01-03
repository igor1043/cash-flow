package com.cashflow.com.cashflow.presentation.home.mock

import com.cashflow.com.cashflow.domain.model.MovementModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement

fun listMovements(): MutableList<MovementModel> {
    val list: MutableList<MovementModel> = mutableListOf()
    list.add(
        createItemMovement(
            MovementsCategories.WAGE,
            100.20,
            "08:30 10/06",
            1,
            StatusMovement.RECEIVED
        )
    )
    list.add(
        createItemMovement(
            MovementsCategories.HOME_REPAIR,
            -200.00,
            "10:30 15/06",
            1,
            StatusMovement.PAID
        )
    )

    list.add(
        createItemMovement(
            MovementsCategories.ELECTRIC_BILLS,
            -80.50,
            "11:20 16/06",
            1,
            StatusMovement.PAID
        )
    )

    list.add(
        createItemMovement(
            MovementsCategories.GAMING,
            -30.00,
            "14:45 18/06",
            1,
            StatusMovement.PAID
        )
    )
    return list
}

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

abstract class MockMovements {

    companion object {
        @JvmStatic
        fun createListMovements(): MutableList<MovementModel> {
            return listMovements()
        }
    }
}