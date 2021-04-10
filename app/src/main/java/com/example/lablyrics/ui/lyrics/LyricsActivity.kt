package com.example.lablyrics.ui.lyrics

import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.ui.lyrics.adapter.LyricsAdapter

class LyricsActivity : AppCompatActivity(), LyrincsScreen {

    lateinit var lyricsAdapter : LyricsAdapter



    override fun showLyricsList(lyricsList: List<String>) {
        TODO("Not yet implemented")
        //lyricsAdapter.setLyrics(lyricsList)
    }
}