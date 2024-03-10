package com.rachellima.favoritelist.viewmodel

import com.rachellima.models.Search

data class FavoritesListState(
    var loading: Boolean = false,
    val searchList: List<Search>? = null,
    val error: Boolean = false
)