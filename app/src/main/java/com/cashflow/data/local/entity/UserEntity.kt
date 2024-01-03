package com.cashflow.com.cashflow.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    indices = [Index(value = ["internal_id"])],
)

data class UsersEntity(
    @ColumnInfo(name = "name")
    var nameUser: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "password")
    var password: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "internal_id")
    var internalId: Int = 0
}
