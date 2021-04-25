package com.example.lablyrics.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lablyrics.model.Lyrics

    @Database(entities = [Lyrics::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun lyricsDAO(): LyricsDAO

        companion object{
            @Volatile
            private var INSTANCE: AppDatabase? = null
            fun getInstance(context: Context): AppDatabase{
                return INSTANCE ?: synchronized(this){
                    INSTANCE ?: Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "lyrics_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                            .also { INSTANCE = it }
                }
            }

        }

    }

