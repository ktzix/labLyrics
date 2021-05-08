package com.example.lablyrics.repository.database

import androidx.room.*
import com.example.lablyrics.model.Lyrics

@Dao
interface LyricsDAO {
    @Query("SELECT * FROM lyrics")
    fun getAllLyrics(): List<Lyrics>

    @Query("SELECT * FROM lyrics WHERE id = :id")
    fun getLyricsById(id: Int): Lyrics

    @Query("SELECT * FROM lyrics WHERE artist = :Artist and title = :Title")
    fun getLyricsByPerformerAndTitle(Artist: String, Title: String): Lyrics

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLyrics( lyrics: Lyrics)

    @Delete
    fun deleteLyrics(lyrics: Lyrics)
}