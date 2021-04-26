package com.example.lablyrics.mock

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.repository.network.LyricsAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockLyricsApi: LyricsAPI {



    override fun getLyrics(artist: String, title: String): Call<Lyrics> {
        val lyrics = Lyrics(1, "Can't buy me love", "The Beatles", "Lorem ipsum" )



    val call = object : Call<Lyrics> {
        @Throws(IOException::class)
        override fun execute(): Response<Lyrics> {
            return Response.success(lyrics)
        }
        override fun enqueue(callback: Callback<Lyrics>) { }
        override fun isExecuted(): Boolean {
            return false
        }
        override fun cancel() { }
        override fun isCanceled(): Boolean {
            return false
        }
        override fun clone(): Call<Lyrics> {
            return this
        }
        override fun request(): Request? {
            return null
        }
    }
    return call

}

    override fun putLyrics(artist: String, title: String, param: Lyrics): Call<Lyrics> {
        TODO("Not yet implemented")
    }

    override fun postLyrics(artist: String, title: String, param: Lyrics): Call<Int> {
        TODO("Not yet implemented")
    }

    override fun deleteLyrics(artist: String, title: String): Call<Void> {
        TODO("Not yet implemented")
    }
}