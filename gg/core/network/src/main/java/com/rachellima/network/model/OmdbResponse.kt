package com.rachellima.network.model

import com.google.gson.annotations.SerializedName
import com.rachellima.models.Search

data class OmdbResponse(
    @SerializedName("Response") val Response: String,
    @SerializedName("Search") val Search: List<Search>,
    @SerializedName("totalResults")  val totalResults: String
)