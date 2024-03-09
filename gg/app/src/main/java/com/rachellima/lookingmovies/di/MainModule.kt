package com.rachellima.lookingmovies.di

import com.rachellima.movies.di.listMoviesModule
import com.rachellima.network.di.networkModule
import com.rachellima.movies.di.repositoryMovieModule
import org.koin.dsl.module

val appModule = module {
    includes(
        repositoryMovieModule,
        networkModule,
        listMoviesModule
    )
}