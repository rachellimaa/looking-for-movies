package com.rachellima.favoritelist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rachellima.models.Search
import com.rachellima.movies.repository.local.FavoritesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesListViewModel(
    private val repositoryFavorites: FavoritesRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var _uiState = MutableStateFlow(FavoritesListState())
    val uiState: StateFlow<FavoritesListState> = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(FavoritesListViewModel::class.java.name, throwable.message ?: "")
        onError()
    }

    init {
        getAllFavoriteList()
    }

    fun getAllFavoriteList() {
        showLoadingState()
        viewModelScope.launch(coroutineDispatcher + coroutineExceptionHandler) {
            val favoritesList = repositoryFavorites.getFavoritesSaved()
            withContext(Dispatchers.Main) {
                onLoadedMoviesWithSuccess(favoritesList)
            }
        }
    }

    fun showLoadingState() {
        _uiState.value = _uiState.value.copy(loading = true)
    }

    fun onLoadedMoviesWithSuccess(searchData: List<Search>) {
        _uiState.value = _uiState.value.copy(loading = false, searchList = searchData)
    }

    fun onError() {
        _uiState.value = _uiState.value.copy(loading = false, error = true)
    }

}