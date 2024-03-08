package com.rachellima.network.model

import com.rachellima.models.Search

data class OmdbResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)