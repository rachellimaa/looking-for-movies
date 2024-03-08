package com.rachellima.lookingmovies.di

import com.rachellima.movies.di.moviesModule
import com.rachellima.network.di.networkModule
import com.rachellima.movies.di.repositoryWeatherModule
import org.koin.dsl.module

val appModule = module {
    includes(
        repositoryWeatherModule,
        networkModule,
        moviesModule
    )
}