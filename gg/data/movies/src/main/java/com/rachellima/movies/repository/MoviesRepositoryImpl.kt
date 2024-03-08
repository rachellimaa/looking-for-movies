package com.rachellima.movies.repository

import com.rachellima.network.api.OmdbApi
import com.rachellima.network.model.OmdbResponse

class MoviesRepositoryImpl(private val api: OmdbApi) : MoviesRepository {
    override suspend fun getAllMovies(title: String): OmdbResponse {
         return api.getMovies(title)
    }
}