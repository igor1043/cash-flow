package com.cashflow.com.cashflow.core.di.module

import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import com.cashflow.com.cashflow.data.repository.FinancesRepositoryImpl
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
    ): FinancesRepository = FinancesRepositoryImpl(database)

}
