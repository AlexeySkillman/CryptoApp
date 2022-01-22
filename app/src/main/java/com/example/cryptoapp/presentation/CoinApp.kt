package com.example.cryptoapp.presentation

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

// Configuration from - import androidx.work.Configuration

//class CoinApp : Application(), Configuration.Provider {

// Configuration.Provider { из-за провайдера пишем
@HiltAndroidApp
class CoinApp: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}