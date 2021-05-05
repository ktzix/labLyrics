package com.example.lablyrics.ui.search

import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.ui.Presenter
import com.example.lablyrics.ui.lyrics.LyricsScreen
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val networkInteractor: NetworkInteractor) : Presenter<SearchScreen?>() {


    fun getLyrics(title: String, artist: String) {
        networkInteractor.getLyrics(artist, title, onSuccess = this::onGetLyricsSucces, this::OnError )
    }

    private fun onGetLyricsSucces(lyrics: LyricsResponse)
    {screen?.showSearch(lyrics)}

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }

}