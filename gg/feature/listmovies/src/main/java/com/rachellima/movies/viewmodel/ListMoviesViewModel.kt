package com.rachellima.movies.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rachellima.models.Search
import com.rachellima.movies.repository.MoviesRepository
import com.rachellima.movies.view.MoviesSearcherHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val EMPTY = ""
class ListMoviesViewModel(
    private val repository: MoviesRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var _uiState = MutableStateFlow(ListMoviesState())
    val uiState: StateFlow<ListMoviesState> = _uiState.asStateFlow()
    var filteredQuery = EMPTY
    private val movieSearcherHelper = MoviesSearcherHelper()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(ListMoviesViewModel::class.java.name, throwable.message ?: "")
        onError()
    }

    fun getAllMovies(title: String) {
        showLoadingState()
        viewModelScope.launch(coroutineDispatcher + coroutineExceptionHandler) {
            val omdbData = repository.getAllMovies(title)
            withContext(Dispatchers.Main) {
                if (omdbData != null) {
                    onLoadedMoviesWithSuccess(omdbData.Search)
                }
            }
        }
    }

    fun searchProductByText(text: String) = movieSearcherHelper.searchMovieByText(text)

    fun saveSearchedItems(searchedItems: List<Search>) {
        onLoadedMoviesWithSuccess(searchedItems)
    }

    private fun showLoadingState() {
        _uiState.value = _uiState.value.copy(loading = true)
    }

    private fun onLoadedMoviesWithSuccess(searchData: List<Search>) {
        _uiState.value = _uiState.value.copy(loading = false, searchList = searchData)
    }

    private fun onError() {
        _uiState.value = _uiState.value.copy(loading = false, error = true)
    }

    fun getLastSearchedTerm(): String {
        return (movieSearcherHelper.getLastSearchedTerm()).ifEmpty {
            filteredQuery
        }
    }
}