package com.example.lablyrics.mock

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.database.LyricsDAO

class MockLyricsDAO: LyricsDAO {

    private var lyricsList = ArrayList<Lyrics>()

    override fun getAllLyrics(): List<Lyrics> {
        return lyricsList
    }

    override fun getLyricsById(id: Int): Lyrics {
        for (l in lyricsList)
            if (l.id==id)
                return l

        return lyricsList[0]
    }

    override fun getLyricsByPerformerAndTitle(Artist: String, Title: String): Lyrics {
        for(l in lyricsList)
            if(l.artist.equals(Artist) && l.title.equals(Title))
                return l
        return lyricsList[0]
    }

    override fun insertLyrics(lyrics: Lyrics) {

        lyricsList.add(lyrics)
    }

    override fun deleteLyrics(lyrics: Lyrics) {
        lyricsList.remove(lyrics)
    }
}