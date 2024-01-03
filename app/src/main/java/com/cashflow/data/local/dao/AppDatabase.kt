package com.cashflow.com.cashflow.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cashflow.com.cashflow.data.local.dao.AppDatabase.Companion.DATABASE_VERSION
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity
import com.cashflow.com.cashflow.data.local.entity.UsersEntity

@Database(
    entities = [
        UsersEntity::class,
        ExpensesEntity::class,
        RevenuesEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract val usersDao: UsersDao
    abstract val expensesDao: ExpensesDao
    abstract val revenuesDao: RevenuesDao

    companion object {
        const val DATABASE_VERSION = 1
    }
}
