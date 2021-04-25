package com.example.lablyrics.ui.search

import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.ui.Presenter
import com.example.lablyrics.ui.lyrics.LyricsScreen
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val networkInteractor: NetworkInteractor) : Presenter<SearchScreen?>() {

    override fun attachScreen(screen: SearchScreen?) {
        super.attachScreen(screen)
    }


    override fun detachScreen() {
        super.detachScreen()
    }

    fun getLyrics(songName: String) {}

    private fun onGetLyricsSucces(lyrics: Lyrics)
    {screen?.showSearch(lyrics)}

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }

}