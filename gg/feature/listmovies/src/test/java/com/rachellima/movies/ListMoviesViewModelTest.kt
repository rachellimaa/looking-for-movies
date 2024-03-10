package com.rachellima.movies

import com.rachellima.models.Search
import com.rachellima.movies.repository.local.FavoritesRepository
import com.rachellima.movies.repository.remote.OmdbRepository
import com.rachellima.movies.viewmodel.ListMoviesViewModel
import com.rachellima.network.model.OmdbResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ListMoviesViewModelTest {

    private lateinit var omdbRepository: OmdbRepository
    private lateinit var favoritesRepository: FavoritesRepository
    private lateinit var viewModel: ListMoviesViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        omdbRepository = mockk()
        favoritesRepository = mockk()
        viewModel = ListMoviesViewModel(omdbRepository, favoritesRepository, testDispatcher)
    }

    @Test
    fun `getAllMovies updates uiState with loaded movies`() = runTest {
        val mockedList =
            listOf(Search("Movie 1", "test1", "", "", ""), Search("Movie 2", "test1", "", "", ""))
        val mockResponse = OmdbResponse("", mockedList, "")
        coEvery { omdbRepository.getAllOmdbResponse(any()) } returns mockResponse

        viewModel.getAllMovies("some_title")

        assertEquals(mockedList, viewModel.uiState.value.searchList)

        coVerify { omdbRepository.getAllOmdbResponse("some_title") }
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

    @Test
    fun `savedItems calls saveFavorites on FavoritesRepository`() = runTest {
        val searchToSave = Search("Movie 1", "test1", "", "", "")
        coEvery { favoritesRepository.saveFavorites(any()) } just runs

        viewModel.savedItems(searchToSave)

        coVerify { favoritesRepository.saveFavorites(searchToSave) }
    }
}
