package com.example.mvparchitecturesample.base

import android.app.Application
import com.example.mvparchitecturesample.di.apiModule
import com.example.mvparchitecturesample.di.networkModule
import com.example.mvparchitecturesample.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)

            modules(
                apiModule,
                networkModule,
                presenterModule
            )
        }
    }
}