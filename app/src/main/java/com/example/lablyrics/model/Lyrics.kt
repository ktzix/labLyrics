package com.example.lablyrics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lyrics")
data class Lyrics(
    @PrimaryKey val id: Int,
    val title: String?,
    val artist: String?,
    val text:  String?
)