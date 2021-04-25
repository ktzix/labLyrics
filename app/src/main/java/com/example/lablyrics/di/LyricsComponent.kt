package com.example.lablyrics.di

import com.example.lablyrics.ui.lyrics.LyricsActivity
import com.example.lablyrics.ui.search.SearchActivity
import com.example.lablyrics.ui.showLyrics.ShowLyricsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[LyricsModule::class])
interface LyricsComponent {
    fun inject(lyricsActivity: LyricsActivity)
    fun inject(searchActivity: SearchActivity)
    fun inject(showLyricsActivity: ShowLyricsActivity)
}