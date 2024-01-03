package com.cashflow.di.module

import com.cashflow.dao.AppDatabase
import com.cashflow.room.ExpensesRepository
import com.cashflow.room.ExpensesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SourceModule {

    @Provides
    fun provideExpensesRepository(
        database: AppDatabase,
    ): ExpensesRepository = ExpensesRepositoryImpl(database)

}
