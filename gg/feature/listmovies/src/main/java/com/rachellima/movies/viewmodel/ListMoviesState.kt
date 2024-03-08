package com.rachellima.movies.viewmodel

import com.rachellima.network.model.OmdbResponse

data class ListMoviesState(
    var loading: Boolean = false,
    val weather: OmdbResponse? = null,
    val error: Boolean = false
)