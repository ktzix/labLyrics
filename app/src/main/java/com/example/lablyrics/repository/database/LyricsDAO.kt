package com.example.lablyrics.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lablyrics.model.Lyrics

@Dao
interface LyricsDAO {
    @Query("SELECT * FROM lyrics")
    fun getAllLyrics(): List<Lyrics>

    @Query("SELECT * FROM lyrics WHERE id = :id")
    fun getLyricsById(id: Int): Lyrics

    @Query("SELECT * FROM lyrics WHERE artist = :Artist and title = :Title")
    fun getLyricsByPerformerAndTitle(Artist: String, Title: String): Lyrics

    @Insert
    fun insertAll(vararg lyrics: Lyrics)

    @Delete
    fun delete(lyrics: Lyrics)
}