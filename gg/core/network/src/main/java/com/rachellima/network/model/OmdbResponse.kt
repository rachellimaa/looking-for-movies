package com.rachellima.network.model

import com.google.gson.annotations.SerializedName
import com.rachellima.models.Search

data class OmdbResponse(
    @SerializedName("Response") val response: String,
    @SerializedName("Search") val searchList: List<Search>,
    @SerializedName("totalResults")  val totalResults: String
)