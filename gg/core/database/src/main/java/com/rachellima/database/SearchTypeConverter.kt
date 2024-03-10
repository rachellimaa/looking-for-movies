package com.rachellima.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.rachellima.models.Search

class SearchTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromSearch(search: Search): String {
        return gson.toJson(search)
    }

    @TypeConverter
    fun toSearch(json: String): Search {
        return gson.fromJson(json, Search::class.java)
    }
}