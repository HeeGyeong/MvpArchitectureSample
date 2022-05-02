package com.example.mvparchitecturesample.di

import com.example.mvparchitecturesample.view.movie.MoviePresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// Contract에 대한 injection이 안된다. MVP pattern에서의 DI 사용법 확인해야함.
val presenterModule: Module = module {
    single { MoviePresenter(get(), get(), get(), get()) }

//    viewModel { MoviePresenter(get(), get(), get(), get()) }
}