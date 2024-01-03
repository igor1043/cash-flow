package com.cashflow.di.module

import android.app.Application
import android.content.Context
import com.cashflow.di.qualifier.ApplicationContext
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}
