package com.example.lablyrics.interactor

import android.os.Handler
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.network.LyricsAPI
import retrofit2.Call
import javax.inject.Inject

class NetworkInteractor @Inject constructor(private var lyricsapi: LyricsAPI){

    private fun <T> runCallOnBackgroundThread(
            call: Call<T>,
            onSuccess: (T) -> Unit,
            onError: (Throwable) -> Unit
    ) {
        val handler = Handler()
        Thread {
            try {
                val response = call.execute().body()!!
                handler.post {
                    onSuccess(response)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                handler.post { onError(e) }
            }
        }.start()
    }

    fun getLyrics(artist : String, title: String, onSuccess:(Lyrics)->Unit, onError: (Throwable) -> Unit) {
        val rek = lyricsapi.getLyrics(artist, title)
    }

    fun createLyrics(artist : String, title: String, lyrics: Lyrics, onSuccess:(Lyrics)->Unit, onError: (Throwable) -> Unit) {
        val rek = lyricsapi.postLyrics(artist, title, lyrics)
    }

    fun delLyrics(artist : String, title: String, onSuccess:(Lyrics)->Unit, onError: (Throwable) -> Unit) {
        val rek = lyricsapi.deleteLyrics(artist, title)
    }

    fun changeLyrics(artist : String, title: String, lyrics: Lyrics, onSuccess:(Lyrics)->Unit, onError: (Throwable) -> Unit) {
        val rek = lyricsapi.putLyrics(artist, title, lyrics)
    }


}