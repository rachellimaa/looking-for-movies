package com.rachellima.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SearchDao {
    @Insert
    suspend fun insert(note: SearchEntity)

    @Update
    suspend fun update(note: SearchEntity)

    @Delete
    suspend fun delete(note: SearchEntity)

    @Query("DELETE FROM favorites_table")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM favorites_table ORDER BY id DESC")
    suspend fun getAllNotes(): List<SearchEntity>
}