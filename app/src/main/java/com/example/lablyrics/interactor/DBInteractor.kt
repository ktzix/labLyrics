package com.example.lablyrics.interactor

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.database.LyricsDAO
import javax.inject.Inject

class DBInteractor @Inject constructor(private var lyricsDAO: LyricsDAO) {


    fun getAllLyrics() = lyricsDAO.getAllLyrics()

    fun getLyricsByID(id : Int) = lyricsDAO.getLyricsById(id)

    fun getLyricsByArtistAndTitle(artist: String, title: String) = lyricsDAO.getLyricsByPerformerAndTitle(artist, title)


    fun insertLyrics(lyrics: Lyrics) { lyricsDAO.insertLyrics(lyrics) }

    fun deleteLyrics(lyrics: Lyrics) { lyricsDAO.deleteLyrics(lyrics) }


}