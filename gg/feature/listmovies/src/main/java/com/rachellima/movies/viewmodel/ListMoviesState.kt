package com.rachellima.movies.viewmodel

import com.rachellima.models.Search

data class ListMoviesState(
    var loading: Boolean = false,
    val searchList: List<Search>? = null,
    val error: Boolean = false
)