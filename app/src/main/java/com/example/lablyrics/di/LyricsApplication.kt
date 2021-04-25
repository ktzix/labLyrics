package com.example.lablyrics.di

import android.app.Application

class LyricsApplication : Application() {
    lateinit var injector: LyricsComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerLyricsComponent.builder().lyricsModule(LyricsModule(this)).build()
    }

}