package com.example.lablyrics.testDI

import android.content.Context
import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.mock.MockLyricsApi
import com.example.lablyrics.mock.MockLyricsDAO
import com.example.lablyrics.repository.database.LyricsDAO
import com.example.lablyrics.repository.network.LyricsAPI
import com.example.lablyrics.ui.search.SearchPresenter
import com.example.lablyrics.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(context: Context) {

    @Provides
    @Singleton
    fun providesMockLyricsApi(): LyricsAPI = MockLyricsApi()

    @Provides
    @Singleton
    fun providesMockLyricsDAO(): LyricsDAO = MockLyricsDAO()

    @Provides
    @Singleton
    fun providesExecutor(): Executor = UiExecutor()

    @Provides
    @Singleton
    fun providesNetworkInteractor(lyricsAPI: LyricsAPI): NetworkInteractor = NetworkInteractor(lyricsAPI)

    @Provides
    @Singleton
    fun providesDBInteractor(lyricsDAO: LyricsDAO): DBInteractor = DBInteractor(lyricsDAO)

    @Provides
    @Singleton
    fun providesSearchPresenter(networkInteractor: NetworkInteractor, dbInteractor: DBInteractor)
    : SearchPresenter = SearchPresenter(networkInteractor, dbInteractor)
}