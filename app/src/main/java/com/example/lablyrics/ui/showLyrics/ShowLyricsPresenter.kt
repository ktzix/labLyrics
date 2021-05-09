package com.example.lablyrics.ui.showLyrics

import android.util.Log
import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.ui.Presenter
import javax.inject.Inject


class ShowLyricsPresenter @Inject constructor(private val networkInteractor: NetworkInteractor,
                                              private val dbInteractor: DBInteractor
): Presenter<ShowLyricsScreen?>() {


    fun updateLyrics(id: Int, newArtist: String, newTitle: String)
    {

        Thread {
             dbInteractor.updateLyrics(id, newArtist, newTitle)
        }.start()

        networkInteractor.changeLyrics(id, onSuccess = this::onUpdateLyricsSucces, onError = this::OnError)
    }

    fun getLyricsById(id: Int){

        Thread{
          val curLyrics =  dbInteractor.getLyricsByID(id)
            screen?.showGetLyricsByIdSucces(curLyrics)
        }.start()


    }

    private fun onUpdateLyricsSucces(song: String)
    { screen?.showUpdateSucces(song)}

    private fun OnError(e: Throwable){
        screen?.showError(e)
    }



}