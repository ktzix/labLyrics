package com.example.lablyrics.mock

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.database.LyricsDAO

class MockLyricsDAO: LyricsDAO {

    private var lyrics = Lyrics("Eminem", "Without Me", "Lorem ipsum")
    private var lyricsList = ArrayList<Lyrics>()

    private fun initList(){lyricsList.add(lyrics)}


    override fun getAllLyrics(): List<Lyrics> {
        initList()
        return lyricsList
    }

    override fun getLyricsById(id: Int): Lyrics {
            return lyrics;
    }

    override fun updateLyrics(id: Int, Artist: String, Title: String) {
        lyricsList[id].title=Title
        lyricsList[id].artist=Artist
    }

    override fun getLyricsByPerformerAndTitle(Artist: String, Title: String): Lyrics {
            return lyrics
    }

    override fun insertLyrics(lyrics: Lyrics) {

        lyricsList.add(lyrics)
    }

    override fun deleteLyrics(lyrics: Lyrics) {
        initList()
        lyricsList.remove(lyrics)
    }
}