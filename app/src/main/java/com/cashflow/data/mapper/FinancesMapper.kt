package com.cashflow.com.cashflow.data.mapper

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import com.cashflow.com.cashflow.domain.model.MovementModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsCategories.Companion.getMovementsCategoriesById
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement.Companion.getStatusMovementById


fun RevenuesEntity.toRevenuesDomain(): MovementModel {
    return MovementModel(
        category = getMovementsCategoriesById(expenseId),
        value = valueExpense,
        date = creationDate,
        user = userId,
        status = getStatusMovementById(status)
    )
}

fun List<MovementModel>.toListRevenuesEntity() : List<RevenuesEntity> {
    val list: MutableList<RevenuesEntity> = mutableListOf()
    this.forEach{
        list.add(it.toRevenuesEntity())
    }
    return list.toList()
}

fun MovementModel.toRevenuesEntity(): RevenuesEntity {
    val revenuesEntity = RevenuesEntity(
        expenseId = this.category.id,
        typeMovementId = this.category.typeMovement.id,
        groupCategoryId = this.category.category.id,
        valueExpense = this.value,
        creationDate = this.date,
        status = this.status?.id ?: 0
    )
    revenuesEntity.userId = 1
    return revenuesEntity
}

fun ExpensesEntity.toExpensesDomain(): MovementModel {
    return MovementModel(
        category = getMovementsCategoriesById(expenseId),
        value = valueExpense,
        date = creationDate,
        user = userId,
        status = getStatusMovementById(this.status)
    )
}

fun List<MovementModel>.toListExpensesEntity() : List<ExpensesEntity> {
    val list: MutableList<ExpensesEntity> = mutableListOf()
    this.forEach{
        list.add(it.toExpensesEntity())
    }
    return list.toList()
}

fun List<ExpensesEntity>.toListExpensesModel() : List<MovementModel> {
    val list: MutableList<MovementModel> = mutableListOf()
    this.forEach{
        list.add(it.toExpensesDomain())
    }
    return list.toList()
}


fun MovementModel.toExpensesEntity(): ExpensesEntity {
    val revenuesEntity = ExpensesEntity(
        expenseId = this.category.id,
        typeMovementId = this.category.typeMovement.id,
        groupCategoryId = this.category.category.id,
        valueExpense = this.value,
        creationDate = this.date,
        status = this.status?.id ?: 0
    )
    revenuesEntity.userId = 1
    return revenuesEntity
}


