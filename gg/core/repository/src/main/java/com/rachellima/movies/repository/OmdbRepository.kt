package com.rachellima.movies.repository

import com.rachellima.network.model.OmdbResponse

interface OmdbRepository {
    suspend fun getAllOmdbResponse(title: String) : OmdbResponse?
}