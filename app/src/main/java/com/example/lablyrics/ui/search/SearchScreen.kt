package com.example.lablyrics.ui.search

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse

interface SearchScreen {

    fun showSearch(lyrics: LyricsResponse/*Result*/)
    fun showError(errorMsg: Throwable)
}