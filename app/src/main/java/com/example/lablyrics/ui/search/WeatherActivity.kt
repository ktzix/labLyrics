package com.example.lablyrics.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class WeatherActivity: AppCompatActivity(), SearchScreen {

    private lateinit var songName: String

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        SearchPresenter.attachScreen(this)
    }

    override fun onStop() {
        SearchPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        SearchPresenter.queryLyrics(songName)
    }

    override fun showSearch(searchResult: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: String) {
        TODO("Not yet implemented")
    }


}