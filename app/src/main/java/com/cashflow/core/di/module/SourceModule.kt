package com.cashflow.com.cashflow.core.di.module

import com.cashflow.com.cashflow.data.local.dao.AppDatabase
import com.cashflow.com.cashflow.domain.repository.FinancesRepository
import com.cashflow.com.cashflow.data.repository.FinancesRepositoryImpl
import com.cashflow.com.cashflow.data.repository.UsersRepositoryImpl
import com.cashflow.com.cashflow.domain.repository.UsersRepository
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

    @Provides
    fun provideUsersRepository(
        database: AppDatabase,
    ): UsersRepository = UsersRepositoryImpl(database)

}
