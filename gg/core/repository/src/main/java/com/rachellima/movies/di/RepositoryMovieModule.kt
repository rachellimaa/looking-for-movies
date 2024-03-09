package com.rachellima.movies.di

import com.rachellima.movies.repository.OmdbRepository
import com.rachellima.movies.repository.OmdbRepositoryImpl
import org.koin.dsl.module

val repositoryMovieModule = module {
    single<OmdbRepository> { OmdbRepositoryImpl(get()) }
}