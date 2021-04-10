package com.example.lablyrics.ui.lyrics

import android.content.Context
import com.example.lablyrics.ui.Presenter

object LyricsPresenter : Presenter<LyrincsScreen>() {

    public override fun attachScreen(screen: LyrincsScreen) {
        super.attachScreen(screen)
    }


    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryLyrics(context: Context){
        TODO()
        /*
        *
        * var lyricsList = getAllLyrics();
        *
        * */
    }
}