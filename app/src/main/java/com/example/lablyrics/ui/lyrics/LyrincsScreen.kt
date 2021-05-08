package com.example.lablyrics.ui.lyrics

import com.example.lablyrics.model.Lyrics

//import lyricsModel

interface LyricsScreen {

    fun showLyricsList(lyricsList: List<Lyrics/*List<Lyrics>*/>)
    fun showDeleteSucces(song : String)
    fun showError(errorMsg: Throwable)
}