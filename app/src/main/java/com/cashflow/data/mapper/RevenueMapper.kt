package com.cashflow.com.cashflow.data.mapper

import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import com.cashflow.com.cashflow.domain.model.RevenueModel
import com.cashflow.com.cashflow.presentation.utils.movements.MovementsRevenueCategories.Companion.getRevenueCategorieById
import com.cashflow.com.cashflow.presentation.utils.movements.StatusMovement.Companion.getStatusMovementById


fun List<RevenuesEntity>.toListRevenueDomain() : List<RevenueModel> {
    val list: MutableList<RevenueModel> = mutableListOf()
    this.forEach{
        list.add(it.toRevenuesDomain())
    }
    return list.toList()
}

fun RevenuesEntity.toRevenuesDomain(): RevenueModel {
    return RevenueModel(
        category = getRevenueCategorieById(expenseId),
        value = valueExpense,
        date = creationDate,
        user = userId,
        status = getStatusMovementById(status)
    )
}


fun List<RevenueModel>.toListRevenuesEntity() : List<RevenuesEntity> {
    val list: MutableList<RevenuesEntity> = mutableListOf()
    this.forEach{
        list.add(it.toRevenuesEntity())
    }
    return list.toList()
}

fun RevenueModel.toRevenuesEntity(): RevenuesEntity {
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


fun List<RevenueModel>.toListRevenueEntity() : List<RevenuesEntity> {
    val list: MutableList<RevenuesEntity> = mutableListOf()
    this.forEach{
        list.add(it.toRevenueEntity())
    }
    return list.toList()
}


fun RevenueModel.toRevenueEntity(): RevenuesEntity {
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


