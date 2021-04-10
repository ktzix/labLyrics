package com.example.lablyrics.ui.search

interface SearchScreen {

    fun showSearch(searchResult: String/*Result*/)
    fun showError(errorMsg: String)
}