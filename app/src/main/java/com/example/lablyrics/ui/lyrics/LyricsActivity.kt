package com.example.lablyrics.ui.lyrics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.ui.lyrics.adapter.LyricsAdapter

class LyricsActivity : AppCompatActivity(), LyrincsScreen {

    lateinit var lyricsAdapter : LyricsAdapter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        LyricsPresenter.attachScreen(this)
    }

    override fun onStop() {
        LyricsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        LyricsPresenter.queryLyrics(this)
    }

    private fun initRecyclerView() {
        lyricsAdapter = LyricsAdapter(this)

    }

    override fun showLyricsList(lyricsList: List<String>) {
        TODO("Not yet implemented")
        //lyricsAdapter.setLyrics(lyricsList)
    }
}