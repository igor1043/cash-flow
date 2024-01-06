package com.cashflow.com.cashflow.data.mapper

import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsExpensesCategories.Companion.getMovementsCategoriesById
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement.Companion.getStatusMovementById


fun ExpensesEntity.toExpenseDomain(): ExpenseModel {
    return ExpenseModel(
        category = getMovementsCategoriesById(expenseId),
        value = valueExpense,
        date = creationDate,
        user = userId,
        status = getStatusMovementById(status)
    )
}

fun ExpensesEntity.toExpensesDomain(): ExpenseModel {
    return ExpenseModel(
        category = getMovementsCategoriesById(expenseId),
        value = valueExpense,
        date = creationDate,
        user = userId,
        status = getStatusMovementById(this.status)
    )
}

fun List<ExpenseModel>.toListExpenseEntity() : List<ExpensesEntity> {
    val list: MutableList<ExpensesEntity> = mutableListOf()
    this.forEach{
        list.add(it.toExpensesEntity())
    }
    return list.toList()
}

fun List<ExpensesEntity>.toListExpensesModel() : List<ExpenseModel> {
    val list: MutableList<ExpenseModel> = mutableListOf()
    this.forEach{
        list.add(it.toExpensesDomain())
    }
    return list.toList()
}

fun ExpenseModel.toExpensesEntity(): ExpensesEntity {
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




