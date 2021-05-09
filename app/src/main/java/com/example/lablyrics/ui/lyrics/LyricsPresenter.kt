package com.example.lablyrics.ui.lyrics

import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.ui.Presenter
import javax.inject.Inject

class LyricsPresenter @Inject constructor(private val networkInteractor: NetworkInteractor,
                                          private val dbInteractor: DBInteractor) : Presenter<LyricsScreen?>() {

    fun getLyrics() {
        Thread{
            var lyricsList = dbInteractor.getAllLyrics()
            onGetLyricsSucces(lyricsList)
        }.start()
    }

    private fun onGetLyricsSucces(lyricsList: List<Lyrics>)
    {
        screen?.showLyricsList(lyricsList)
    }

    fun delLyrics(lyrics: Lyrics){
        Thread {dbInteractor.deleteLyrics(lyrics) }.start()
        networkInteractor.delLyrics(lyrics.artist!!, lyrics.title!!,onSuccess = this::onDeleteSucces, onError = this::OnError )
    }

    private fun onDeleteSucces(song : String){
        screen?.showDeleteSucces(song)
    }

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }

}