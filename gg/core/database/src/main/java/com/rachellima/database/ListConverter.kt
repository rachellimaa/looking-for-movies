package com.rachellima.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    @TypeConverter
    fun fromSearchEntity(value: String): List<SearchEntity> {
        val listType = object : TypeToken<List<SearchEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<SearchEntity>): String {
        return Gson().toJson(list)
    }
}
