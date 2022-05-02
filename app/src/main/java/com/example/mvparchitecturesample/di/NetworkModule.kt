package com.example.mvparchitecturesample.di

import com.example.mvparchitecturesample.util.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}