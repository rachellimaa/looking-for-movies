package com.rachellima.movies.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rachellima.movies.viewmodel.ListMoviesViewModel
import com.rachellima.listmovies.R
import com.rachellima.listmovies.databinding.FragmentListMoviesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment(R.layout.fragment_list_movies) {
    private val binding by lazy {
        FragmentListMoviesBinding.inflate(layoutInflater)
    }

    private val viewModel: ListMoviesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllMovies("Batman")
        binding.textCall.text = viewModel.uiState.value.weather.toString()
    }
}