package com.example.lablyrics.ui.search

import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.ui.Presenter
import javax.inject.Inject


class SearchPresenter @Inject constructor(private val networkInteractor: NetworkInteractor,
                                          private val dbInteractor: DBInteractor) : Presenter<SearchScreen?>() {


    fun getLyrics(title: String, artist: String) {
        networkInteractor.getLyrics(artist, title, onSuccess = this::onGetLyricsSucces, this::OnError )
    }

     fun addLyricsToDB(lyrics: Lyrics)
    {
        Thread {
            val _lyrics = dbInteractor.getLyricsByArtistAndTitle(lyrics.artist!!, lyrics.title!!)
                dbInteractor.insertLyrics(lyrics)
        }.start()
        networkInteractor.createLyrics(lyrics, onSuccess = this::onAddLyricsSucces, onError = this::OnError)
    }

    private fun onAddLyricsSucces(lyrics: Lyrics)
    {
        screen?.showAddSucces(lyrics)
    }

    private fun onGetLyricsSucces(lyrics: LyricsResponse)
    { screen?.showSearch(lyrics)}

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }

}