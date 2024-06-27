package com.cashflow.com.cashflow.core.di.module

import android.app.Application
import android.content.Context
import com.cashflow.com.cashflow.core.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(
    includes = [
        SourceModule::class,
    ]
)

@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}
