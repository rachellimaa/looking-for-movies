package com.rachellima.movies.di

import com.rachellima.movies.repository.remote.OmdbRepository
import com.rachellima.movies.repository.remote.OmdbRepositoryImpl
import org.koin.dsl.module

val repositoryMovieModule = module {
    single<OmdbRepository> { OmdbRepositoryImpl(get()) }
}