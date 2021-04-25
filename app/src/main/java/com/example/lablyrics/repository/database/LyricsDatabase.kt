package com.example.lablyrics.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lablyrics.model.Lyrics

class LyricsDatabase {

    @Database(entities = [Lyrics::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun lyricsDAO(): LyricsDAO
    }

}