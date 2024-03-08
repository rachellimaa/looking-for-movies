package com.rachellima.network.di

import com.rachellima.network.providers.ApiInstance
import org.koin.dsl.module

const val OMDB_BASE_URL = "http://www.omdbapi.com/"

val networkModule = module {
    single { ApiInstance.getApi(get(), OMDB_BASE_URL) }
}
