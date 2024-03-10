package com.rachellima.movies.repository.local

import com.rachellima.models.Search

interface FavoritesRepository {
    fun getFavoritesSaved() : List<Search>
    fun saveFavorites(search: Search)
}