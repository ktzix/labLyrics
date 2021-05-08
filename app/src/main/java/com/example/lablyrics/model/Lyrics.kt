package com.example.lablyrics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "lyrics", indices = [Index(value = ["artist", "title"], unique = true)])
data class Lyrics(
    var artist: String?,
    var title: String?,
    var text:  String?
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0

}