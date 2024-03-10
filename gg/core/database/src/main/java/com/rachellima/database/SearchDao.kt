package com.rachellima.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SearchDao {
    @Insert
    fun insertSearch(search: SearchEntity)

    @Query("SELECT * FROM ${TableNames.FAVORITES} ORDER BY id DESC")
    fun getAllSearch(): List<SearchEntity>
}