package com.example.lablyrics.ui.showLyrics

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse

interface ShowLyricsScreen {


    fun showError(errorMsg: Throwable)
    fun showUpdateSucces(song: String)
    fun showGetLyricsByIdSucces(lyrics: Lyrics)

}