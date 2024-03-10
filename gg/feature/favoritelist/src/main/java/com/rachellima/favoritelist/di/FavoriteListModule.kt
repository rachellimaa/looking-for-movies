package com.rachellima.favoritelist.di

import com.rachellima.favoritelist.viewmodel.FavoritesListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteListModule = module {
    viewModel { FavoritesListViewModel(get(), get()) }
    factory { Dispatchers.IO }
}