package com.rachellima.movies.repository

import com.rachellima.network.api.OmdbApi
import com.rachellima.network.model.OmdbResponse

class OmdbRepositoryImpl(private val api: OmdbApi) : OmdbRepository {
    override suspend fun getAllOmdbResponse(title: String): OmdbResponse? {
         return api.getOmdbResponse(title).body()
    }
}