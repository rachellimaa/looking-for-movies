package com.rachellima.movies.view

import com.rachellima.models.Search

class MoviesSearcherHelper {
    private var lastSearchedTerm = ""
    private val products = mutableListOf<Search>()

    fun updateList(products: List<Search>) {
        this.products.clear()
        this.products.addAll(products)
    }

    fun getLastSearchedTerm() = lastSearchedTerm

    fun updateLastSearchedTerm(term: String) {
        lastSearchedTerm = term
    }
    fun getAll() = products

    fun searchMovieByText(text: String): List<Search> {
        lastSearchedTerm = text

        if (text.isEmpty()) {
            return getAll()
        }

        return products.filter {
            it.titleItem.contains(text, ignoreCase = true) ||
                    it.imdbID.contains(text, ignoreCase = true) ||
                    it.yearItem.contains(text, ignoreCase = true)
        }
    }

    fun searchProductsByLastSearch(): List<Search> {
        return searchMovieByText(lastSearchedTerm)
    }
}
