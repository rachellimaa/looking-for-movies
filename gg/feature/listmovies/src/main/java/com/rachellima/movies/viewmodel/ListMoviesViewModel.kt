package com.rachellima.movies.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rachellima.models.Search
import com.rachellima.movies.repository.OmdbRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListMoviesViewModel(
    private val repository: OmdbRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var _uiState = MutableStateFlow(ListMoviesState())
    val uiState: StateFlow<ListMoviesState> = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(ListMoviesViewModel::class.java.name, throwable.message ?: "")
        onError()
    }

    private fun getAllMovies(title: String) {
        showLoadingState()
        viewModelScope.launch(coroutineDispatcher + coroutineExceptionHandler) {
            val omdbData = repository.getAllOmdbResponse(title)
            withContext(Dispatchers.Main) {
                if (omdbData != null) {
                    onLoadedMoviesWithSuccess(omdbData.searchList)
                }
            }
        }
    }

    fun searchProductByText(text: String) {
        getAllMovies(text)
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

}