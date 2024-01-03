package com.cashflow.com.cashflow.data.local.dao

import androidx.room.*
import com.cashflow.com.cashflow.data.local.entity.UsersEntity

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: UsersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(item: UsersEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listItems: List<UsersEntity>)

    @Update
    fun update(unitConsumer: UsersEntity)

    @Delete()
    fun delete(unitConsumer: UsersEntity)

    @Query("SELECT * FROM users")
    fun getUsers(): List<UsersEntity>

    @Query("SELECT * FROM users WHERE internal_id = :userId")
    fun getUser(userId: Int): UsersEntity
}