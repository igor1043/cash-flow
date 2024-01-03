package com.cashflow.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cashflow.dao.AppDatabase.Companion.DATABASE_VERSION
import com.cashflow.room.ExpensesDao
import com.cashflow.room.ExpensesEntity

@Database(
    entities = [
        ExpensesEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract val expensesDao: ExpensesDao

    companion object {
        const val DATABASE_VERSION = 1
    }
}
