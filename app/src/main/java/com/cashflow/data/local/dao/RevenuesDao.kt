package com.cashflow.com.cashflow.data.local.dao

import androidx.room.*
import com.cashflow.com.cashflow.data.local.entity.ExpensesEntity
import com.cashflow.com.cashflow.data.local.entity.RevenuesEntity

@Dao
interface RevenuesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: RevenuesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(item: RevenuesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listItems: List<RevenuesEntity>)

    @Update
    fun update(unitConsumer: RevenuesEntity)

    @Delete()
    fun delete(unitConsumer: RevenuesEntity)

    @Query("SELECT * FROM revenues WHERE internal_id = :internalId")
    fun getRevenues(
        internalId: Int,
    ): List<RevenuesEntity>
}