package com.example.lablyrics.di

import android.content.Context
import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.interactor.NetworkInteractor
import com.example.lablyrics.repository.database.AppDatabase
import com.example.lablyrics.repository.database.LyricsDAO
import com.example.lablyrics.repository.network.LyricsAPI
import com.example.lablyrics.ui.lyrics.LyricsPresenter
import com.example.lablyrics.ui.search.SearchPresenter
import com.example.lablyrics.ui.showLyrics.ShowLyricsPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class LyricsModule(private var context: Context) {

    @Provides
    @Singleton
    fun provideLyricsApi(): LyricsAPI{
        val retrofit = Retrofit.Builder()
                .baseUrl(LyricsAPI.ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

                return retrofit.create(LyricsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideLyricsDAO(): LyricsDAO{
        return AppDatabase.getInstance(context).lyricsDAO()
    }

    @Provides
    @Singleton
    fun providesDBInteractor(lyricsDAO: LyricsDAO) = DBInteractor(lyricsDAO)

    @Provides
    @Singleton
    fun providesNetworkInteractor(lyricsAPI: LyricsAPI) = NetworkInteractor(lyricsAPI)

    @Provides
    @Singleton
    fun providesLyricsPresenter() = LyricsPresenter()

    @Provides
    @Singleton
    fun providesShowLyricsPresenter() = ShowLyricsPresenter()

    @Provides
    @Singleton
    fun providesSearchPresenter(networkInteractor: NetworkInteractor) = SearchPresenter(networkInteractor)

}