package com.example.lablyrics.ui.search

import com.example.lablyrics.model.Lyrics

interface SearchScreen {

    fun showSearch(lyrics: Lyrics/*Result*/)
    fun showError(errorMsg: Throwable)
}