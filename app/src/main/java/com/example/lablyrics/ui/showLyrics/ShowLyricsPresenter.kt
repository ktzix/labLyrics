package com.example.lablyrics.ui.showLyrics

import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.ui.Presenter
import javax.inject.Inject


class ShowLyricsPresenter @Inject constructor(private val networkInteractor: NetworkInteractor,
                                              private val dbInteractor: DBInteractor
): Presenter<ShowLyricsScreen?>() {


    fun updateLyrics(lyrics: Lyrics)
    {
        Thread {
             dbInteractor.updateLyrics(lyrics.id, lyrics.artist!!, lyrics.title!!, lyrics.text!!)
        }.start()

        networkInteractor.changeLyrics(lyrics, onSuccess = this::onUpdateLyricsSucces, onError = this::OnError)
    }


    private fun onUpdateLyricsSucces(song: String)
    { screen?.showUpdateSucces(song)}

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }



}