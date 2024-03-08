package com.rachellima.movies.di

import com.rachellima.movies.repository.MoviesRepository
import com.rachellima.movies.repository.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryWeatherModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
}