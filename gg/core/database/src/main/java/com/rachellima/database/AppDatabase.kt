package com.rachellima.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        SearchEntity::class
    ],
    version = 1,
    exportSchema = true,
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}