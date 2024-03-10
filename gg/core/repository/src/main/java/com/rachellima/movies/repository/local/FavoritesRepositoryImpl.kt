package com.rachellima.movies.repository.local

import com.rachellima.database.SearchDao
import com.rachellima.database.SearchEntity
import com.rachellima.database.asSearch
import com.rachellima.models.Search

class FavoritesRepositoryImpl(private val searchDao: SearchDao) : FavoritesRepository {
    override fun getFavoritesSaved(): List<Search> {
        return searchDao.getAllSearch().map {
            it.asSearch()
        }
    }

    override fun saveFavorites(search: Search) {
        searchDao.insertSearch(SearchEntity(savedSearch = search))
    }
}