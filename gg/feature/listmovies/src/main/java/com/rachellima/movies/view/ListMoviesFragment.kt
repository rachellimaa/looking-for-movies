package com.rachellima.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rachellima.common.DebouncingQueryTextListener
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
        setupSearchView()
        setupListenersSearchView()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    state.searchList?.let {
                        setupList(it)
                        configNumberOfProducts(it.size)
                    }
                }
            }
        }
        binding.goToFavoriteList.setOnClickListener {
            findNavController().navigate(
                R.id.listMoviesToFavorites
            )
        }
    }

    private fun configNumberOfProducts(size: Int) {
        binding.moviesCount.text =
            requireContext().getString(R.string.quantity_items, size.toString())
    }

    private fun setupList(searchList: List<Search>) {
        with(binding) {
            moviesListRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = MoviesAdapter(
                    searchList,
                    ::savedSearchItem
                )
            }
        }
    }

    private fun savedSearchItem(search: Search) {
        viewModel.savedItems(search)
    }

    private fun setupSearchView() {
        binding.searchMoviesSearchView.apply {
            setOnQueryTextListener(createSearchViewChangeListener())
            setQuery("", false)
        }
    }

    private fun createSearchViewChangeListener(): androidx.appcompat.widget.SearchView.OnQueryTextListener {
        return object : DebouncingQueryTextListener() {
            override fun onDelayedQueryTextChange(query: String?) {
                onSearchTextChange(query ?: "")
            }
        }
    }

    private fun setupListenersSearchView() {
        with(binding.searchMoviesSearchView) {
            try {
                val id = context.resources.getIdentifier(
                    "android:id/search_close_btn",
                    null, null
                )
                val close = findViewById<ImageView>(id)
                close.setOnClickListener {
                    setQuery("", false)
                    clearFocus()
                }
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    private fun onSearchTextChange(text: String) {
        viewModel.searchProductByText(text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}