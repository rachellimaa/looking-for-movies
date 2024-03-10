package com.rachellima.movies.repository.remote

import com.rachellima.network.model.OmdbResponse

interface OmdbRepository {
    suspend fun getAllOmdbResponse(title: String) : OmdbResponse?
}