package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// The Hilt module AnalyticsModule is annotated with @InstallIn(ActivityComponent::class)
// because you want Hilt to inject that dependency into ExampleActivity.
// This annotation means that all of the dependencies in AnalyticsModule are available
// in all of the app's activities.

@Module
@InstallIn(SingletonComponent::class) // ActivityComponent для Активити
interface DataModule {

    @Singleton
    @Binds // or Provides
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository


    companion object{

        // Наверно так
        @Singleton
        @Provides // or Provides
        fun provideCoinInfoDao( application: Application): CoinInfoDao {
            return  AppDatabase.getInstance(application).coinPriceInfoDao()
        }
        @Singleton
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

    }
}