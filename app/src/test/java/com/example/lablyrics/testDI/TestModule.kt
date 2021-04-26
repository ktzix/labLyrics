package com.example.lablyrics.testDI

import com.example.lablyrics.mock.MockLyricsApi
import com.example.lablyrics.mock.MockLyricsDAO
import com.example.lablyrics.repository.database.LyricsDAO
import com.example.lablyrics.repository.network.LyricsAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule {

    @Provides
    @Singleton
    fun providesMockLyricsApi(): LyricsAPI = MockLyricsApi()

    @Provides
    @Singleton
    fun providesMockLyricsDAO(): LyricsDAO = MockLyricsDAO()

}