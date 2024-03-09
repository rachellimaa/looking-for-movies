package com.rachellima.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rachellima.listmovies.R
import com.rachellima.listmovies.databinding.FragmentListMoviesBinding
import com.rachellima.models.Search
import com.rachellima.movies.adapter.MoviesAdapter
import com.rachellima.movies.viewmodel.ListMoviesViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment(R.layout.fragment_list_movies) {
    private var _binding: FragmentListMoviesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListMoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllMovies("Batman")
      //  setupSearchView()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    state.searchList?.let { setupList(it) }
                }
            }
        }
    }

    private fun setupList(searchList: List<Search>) {
        with(binding) {
            catalogRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = MoviesAdapter(
                    searchList
                )
            }
        }
    }

    private fun setupSearchView() {
        binding.searchMoviesSearchView.apply {
            setOnQueryTextListener(createSearchViewChangeListener())
            setQuery(viewModel.getLastSearchedTerm(), false)
        }
    }

    private fun createSearchViewChangeListener(): androidx.appcompat.widget.SearchView.OnQueryTextListener {
        return object : DebouncingQueryTextListener() {
            override fun onDelayedQueryTextChange(query: String?) {
                onSearchTextChange(query ?: "")
            }
        }
    }

    private fun onSearchTextChange(text: String) {
        viewModel.filteredQuery = text
        saveSearchedItems(items = viewModel.searchProductByText(text))
    }

    private fun saveSearchedItems(items: List<Search>) {
        viewModel.saveSearchedItems(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}