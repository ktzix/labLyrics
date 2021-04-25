package com.example.lablyrics.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.network.LyricsDAO

class LyricsDatabase {

    @Database(entities = [Lyrics::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun lyricsDAO(): LyricsDAO
    }

}