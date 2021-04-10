package com.example.lablyrics.ui.lyrics

import android.content.Context
import com.example.lablyrics.ui.Presenter
import com.example.lablyrics.ui.search.SearchActivity

object LyricsPresenter : Presenter<LyricsScreen?>() {

   override fun attachScreen(screen: LyricsScreen?) {
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