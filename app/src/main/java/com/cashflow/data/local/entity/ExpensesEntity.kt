package com.cashflow.com.cashflow.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = UsersEntity::class,
            parentColumns = ["internal_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ],
)

data class ExpensesEntity(
    @ColumnInfo(name = "expense_id")
    var expenseId: Int,
    @ColumnInfo(name = "type_movement_id")
    var typeMovementId: Int,
    @ColumnInfo(name = "group_category_id")
    var groupCategoryId: Int,
    @ColumnInfo(name = "value_expense")
    var valueExpense: Double,
    @ColumnInfo(name = "creation_date")
    var creationDate: String,
    @ColumnInfo(name = "status")
    var status: Int,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "internal_id")
    var internalId: Int = 0
    @ColumnInfo(name = "user_id")
    var userId: Int = 0
}
