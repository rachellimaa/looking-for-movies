package com.rachellima.network.api

import com.rachellima.network.model.OmdbResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {
    @GET("?")
    suspend fun getMovies(
        @Query("s") title: String,
        @Query("page") page: Int = 2,
        @Query("apikey") apikey: String = "523b6aa5",
    ): OmdbResponse
}