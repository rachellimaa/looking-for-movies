package com.rachellima.favoritelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rachellima.favoritelist.R
import com.rachellima.favoritelist.adapter.FavoriteListAdapter
import com.rachellima.favoritelist.databinding.FragmentFavoriteListBinding
import com.rachellima.favoritelist.viewmodel.FavoritesListViewModel
import com.rachellima.models.Search
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteListFragment : Fragment(R.layout.fragment_favorite_list) {
    private var _binding: FragmentFavoriteListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavoritesListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    state.searchList?.let {
                        setupList(it)
                        configNumberOfProducts(it.size)
                    }
                    configureLoading(state.loading)
                }
            }
        }
    }

    private fun configureLoading(loading: Boolean) {
        binding.loadingProgressBar.isVisible = loading
    }

    private fun configNumberOfProducts(size: Int) {
        binding.moviesCountFavorites.text =
            requireContext().getString(R.string.quantity_items_favorites, size.toString())
    }

    private fun setupList(searchList: List<Search>) {
        with(binding) {
            favoriteListRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = FavoriteListAdapter(
                    searchList
                )
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}