package com.rachellima.forecast

import com.rachellima.favoritelist.viewmodel.FavoritesListViewModel
import com.rachellima.models.Search
import com.rachellima.movies.repository.local.FavoritesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FavoritesListViewModelTest {
    private lateinit var favoritesRepository: FavoritesRepository
    private lateinit var viewModel: FavoritesListViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        favoritesRepository = mockk()
        viewModel = FavoritesListViewModel(favoritesRepository, testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getAllFavoriteList updates uiState with loaded movies`() = runTest {
        // Mock the repository response
        val mockedList =
            listOf(Search("Movie 1", "test1", "", "", ""), Search("Movie 2", "test1", "", "", ""))
        coEvery { favoritesRepository.getFavoritesSaved() } returns mockedList

        viewModel.getAllFavoriteList()

        assertEquals(mockedList, viewModel.uiState.value.searchList)
        coVerify { favoritesRepository.getFavoritesSaved() }
    }

    @Test
    fun `onError updates uiState with error`() = runTest {
        viewModel.onError()

        assertEquals(false, viewModel.uiState.value.loading)
        assertEquals(true, viewModel.uiState.value.error)
    }

    @Test
    fun `showLoadingState updates uiState with loading state`() {
        viewModel.showLoadingState()

        assertEquals(true, viewModel.uiState.value.loading)
    }
}