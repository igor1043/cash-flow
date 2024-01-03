package com.cashflow.com.cashflow.core.di.module

import android.content.Context
import androidx.room.Room
import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun databaseProvider(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "cash-flow.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}