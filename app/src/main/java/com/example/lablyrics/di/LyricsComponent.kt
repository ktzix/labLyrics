package com.example.lablyrics.di

import com.example.lablyrics.ui.lyrics.LyricsActivity
import dagger.Component

@Component(modules=[LyricsModule::class])
interface LyricsComponent {
    fun inject(app: LyricsActivity)
}