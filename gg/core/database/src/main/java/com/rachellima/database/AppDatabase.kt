package com.rachellima.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        SearchEntity::class
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(SearchTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}