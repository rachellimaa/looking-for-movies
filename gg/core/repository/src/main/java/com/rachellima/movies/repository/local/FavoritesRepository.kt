package com.rachellima.movies.repository.local

import com.rachellima.models.Search

interface FavoritesRepository {
    suspend fun getFavoritesSaved() : List<Search>?
}