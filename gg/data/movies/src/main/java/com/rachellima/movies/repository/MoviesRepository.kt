package com.rachellima.movies.repository

import com.rachellima.network.model.OmdbResponse

interface MoviesRepository {
    suspend fun getAllMovies(title: String) : OmdbResponse?
}