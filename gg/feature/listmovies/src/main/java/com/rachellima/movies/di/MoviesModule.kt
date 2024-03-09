package com.rachellima.movies.di

import com.rachellima.movies.viewmodel.ListMoviesViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listMoviesModule = module {
    viewModel { ListMoviesViewModel(get(), get()) }
    factory { Dispatchers.IO }
}