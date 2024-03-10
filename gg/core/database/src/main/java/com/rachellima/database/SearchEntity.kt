package com.rachellima.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rachellima.models.Search

@Entity(tableName = TableNames.FAVORITES)
data class SearchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val savedSearch: Search
)

fun SearchEntity.asSearch() = Search(
    this.savedSearch.urlPoster,
    this.savedSearch.titleItem,
    this.savedSearch.typeItem,
    this.savedSearch.yearItem,
    this.savedSearch.imdbID
)