package com.example.lablyrics.interactor

import android.os.Handler
import android.util.Log
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.repository.network.LyricsAPI
import retrofit2.Call
import javax.inject.Inject

class NetworkInteractor @Inject constructor(private var lyricsapi: LyricsAPI){

    private fun <T> runCallOnBackgroundThread(
            call: Call<T>,
            onSuccess: (T) -> Unit,
            onError: (Throwable) -> Unit
    ) {


            try {
                val c = call.execute()
                Log.d("code", c.code().toString())
                val response = c.body()!!

                    onSuccess(response)


            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }

    }

    fun getLyrics(artist : String, title: String, onSuccess:(LyricsResponse)->Unit, onError: (Throwable) -> Unit) {

        val rek = lyricsapi.getLyrics(artist, title)

        runCallOnBackgroundThread(rek, onSuccess, onError)
    }

    fun createLyrics(lyrics: Lyrics, onSuccess:(Lyrics)->Unit, onError: (Throwable) -> Unit) {
       onSuccess(lyrics)
    }

    fun delLyrics(artist : String, title: String, onSuccess:(String)->Unit, onError: (Throwable) -> Unit) {
        onSuccess("$artist - $title")
    }

    fun changeLyrics(id: Int,
                     onSuccess:(String)->Unit, onError: (Throwable) -> Unit) {
        onSuccess("$id modositva")
    }


}