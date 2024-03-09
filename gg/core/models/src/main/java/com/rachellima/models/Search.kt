package com.rachellima.models

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Poster") val urlPoster: String,
    @SerializedName("Title") val titleItem: String,
    @SerializedName("Type") val typeItem: String,
    @SerializedName("Year") val yearItem: String,
    @SerializedName("imdbID") val imdbID: String
)