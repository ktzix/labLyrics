package com.example.lablyrics.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.model.Lyrics
import javax.inject.Inject

class SearchActivity: AppCompatActivity(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter
    private lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        searchPresenter.attachScreen(this)
    }

    override fun onStop() {
        searchPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        searchPresenter.getLyrics(title)
    }

    override fun showSearch(lyrics: Lyrics) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
    }


}