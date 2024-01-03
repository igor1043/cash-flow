package com.cashflow.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "expenses",
    indices = [Index(value = ["internal_id"])],
)

data class ExpensesEntity(
    @ColumnInfo(name = "value_expense")
    var valueExpense: Double,
    @ColumnInfo(name = "creation_date")
    var creationDate: String,
    @ColumnInfo(name = "status")
    var status: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "internal_id")
    var internalId: Int = 0
}
