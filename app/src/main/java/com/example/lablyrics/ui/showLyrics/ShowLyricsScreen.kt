package com.example.lablyrics.ui.showLyrics

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse

interface ShowLyricsScreen {

    fun showSearch(lyrics: LyricsResponse/*Result*/)
    fun showError(errorMsg: Throwable)


}