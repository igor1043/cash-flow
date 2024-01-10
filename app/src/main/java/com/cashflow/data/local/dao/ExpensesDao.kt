package com.cashflow.com.cashflow.data.local.dao

import androidx.room.*
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity

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

    @Query("SELECT * FROM expenses WHERE user_id = :userId AND substr(creation_date, 1, 7) = :targetMonth ORDER BY creation_date DESC LIMIT 5")
    fun getExpensesForMonth(
        userId: Int,
        targetMonth: String // Formato: "YYYY-MM", por exemplo, "2024-01" para janeiro de 2024
    ): List<ExpensesEntity>

    @Query("SELECT SUM(value_expense) as totalAmount FROM expenses WHERE user_id = :userId AND substr(creation_date, 1, 7) = :targetMonth")
    fun getTotalExpensesForMonth(
        userId: Int,
        targetMonth: String // Formato: "YYYY-MM", por exemplo, "2024-01" para janeiro de 2024
    ): Int

    @Query("SELECT * FROM expenses WHERE user_id = :userId AND substr(creation_date, 1, 10) = :targetMonth")
    fun getExpensesByDay(
        userId: Int,
        targetMonth: String
    ): List<ExpensesEntity>

    @Query("SELECT * FROM revenues WHERE user_id = :userId AND substr(creation_date, 1, 10) = :targetMonth")
    fun getRevenuesByDay(
        userId: Int,
        targetMonth: String
    ): List<RevenuesEntity>
}