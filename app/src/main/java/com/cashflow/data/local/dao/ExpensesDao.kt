package com.cashflow.com.cashflow.data.local.dao

import androidx.room.*
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity

@Dao
interface ExpensesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: ExpensesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(item: ExpensesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listItems: List<ExpensesEntity>)

    @Update
    fun update(unitConsumer: ExpensesEntity)

    @Delete()
    fun delete(unitConsumer: ExpensesEntity)

    @Query("SELECT * FROM expenses WHERE internal_id = :internalId")
    fun getExpense(
        internalId: Int,
    ): ExpensesEntity

    @Query("SELECT * FROM expenses WHERE user_id = :userId")
    fun getExpenses(
        userId: Int
    ): List<ExpensesEntity>

    @Query("SELECT * FROM expenses WHERE user_id = :userId ORDER BY creation_date DESC LIMIT 5")
    fun getRecentExpenses(
        userId: Int
    ): List<ExpensesEntity>
}