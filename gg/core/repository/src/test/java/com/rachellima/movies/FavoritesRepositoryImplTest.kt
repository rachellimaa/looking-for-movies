package com.rachellima.movies

import com.rachellima.database.SearchDao
import com.rachellima.database.SearchEntity
import com.rachellima.database.asSearch
import com.rachellima.models.Search
import com.rachellima.movies.repository.local.FavoritesRepository
import com.rachellima.movies.repository.local.FavoritesRepositoryImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class FavoritesRepositoryImplTest {

    private lateinit var favoritesRepository: FavoritesRepository
    private val searchDao: SearchDao = mockk()

    @Before
    fun setup() {
        favoritesRepository = FavoritesRepositoryImpl(searchDao)
    }

    @Test
    fun `getFavoritesSaved returns correct list of Search`() {
        val searchEntities = listOf(
            SearchEntity(id = 1, savedSearch = Search("Movie 1", "test1", "", "", "")),
            SearchEntity(id = 2, savedSearch = Search("Movie 2", "test2", "", "", "")))
        every { searchDao.getAllSearch() } returns searchEntities

        val result = favoritesRepository.getFavoritesSaved()

        verify { searchDao.getAllSearch() }

        assertEquals(searchEntities.map { it.asSearch() }, result)
    }

    @Test
    fun `saveFavorites inserts the correct SearchEntity`() {
        val searchToSave = Search("Movie saved", "test1", "", "", "")
        val searchEntityToSave = SearchEntity(savedSearch = searchToSave)
        every { searchDao.insertSearch(any()) } answers {
            val insertedEntity: SearchEntity = arg(0)
            assertEquals(searchEntityToSave, insertedEntity)
        }

        favoritesRepository.saveFavorites(searchToSave)

        verify { searchDao.insertSearch(any()) }
    }
}