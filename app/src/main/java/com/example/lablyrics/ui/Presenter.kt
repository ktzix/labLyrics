package com.example.lablyrics.ui

import com.example.lablyrics.ui.search.SearchActivity

abstract class Presenter<S> {
    protected var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        this.screen = null
    }
}