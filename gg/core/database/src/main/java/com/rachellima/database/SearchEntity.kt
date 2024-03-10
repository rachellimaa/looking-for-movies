package com.rachellima.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class SearchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val savedList: String
)