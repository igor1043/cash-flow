package com.cashflow.home.mock

import com.cashflow.home.modelview.MovementUiModel
import com.cashflow.utils.movements.MovementsCategories
import com.cashflow.utils.movements.StatusMovement

fun listMovements(): MutableList<MovementUiModel> {
    val list: MutableList<MovementUiModel> = mutableListOf()
    list.add(
        createItemMovement(
            MovementsCategories.WAGE,
            100.20,
            "08:30 10/06",
            StatusMovement.RECEIVED
        )
    )
    list.add(
        createItemMovement(
            MovementsCategories.HOME_REPAIR,
            -200.00,
            "10:30 15/06",
            StatusMovement.PAID
        )
    )

    list.add(
        createItemMovement(
            MovementsCategories.ELECTRIC_BILLS,
            -80.50,
            "11:20 16/06",
            StatusMovement.PAID
        )
    )

    list.add(
        createItemMovement(
            MovementsCategories.GAMING,
            -30.00,
            "14:45 18/06",
            StatusMovement.PAID
        )
    )
    return list
}

fun createItemMovement(
    category: MovementsCategories,
    value: Double,
    date: String,
    status: StatusMovement,
): MovementUiModel {
    return MovementUiModel(
        category,
        value,
        date,
        status,
    )
}

abstract class MockMovements {

    companion object {
        @JvmStatic
        fun createListMovements(): MutableList<MovementUiModel> {
            return listMovements()
        }
    }
}