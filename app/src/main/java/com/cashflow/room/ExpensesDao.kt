package com.cashflow.room

import androidx.room.*

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
    ): List<ExpensesEntity>
}