package com.example.lablyrics.ui.search

import com.example.lablyrics.ui.Presenter
import com.example.lablyrics.ui.lyrics.LyricsScreen

object SearchPresenter: Presenter<SearchScreen?>() {

    override fun attachScreen(screen: SearchScreen?) {
        super.attachScreen(screen)
    }


    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryLyrics(songName: String) {}

}