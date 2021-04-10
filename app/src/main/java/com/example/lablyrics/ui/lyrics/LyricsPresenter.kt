package com.example.lablyrics.ui.lyrics

import android.content.Context
import com.example.lablyrics.ui.Presenter
import com.example.lablyrics.ui.search.WeatherActivity

object LyricsPresenter : Presenter<LyrincsScreen>() {

    public override fun attachScreen(screen: WeatherActivity) {
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