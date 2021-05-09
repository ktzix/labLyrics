package com.example.lablyrics.mock

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.repository.network.LyricsAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockLyricsApi: LyricsAPI {



    override fun getLyrics(artist: String, title: String): Call<LyricsResponse> {
        val lyrics = LyricsResponse( "Lorem ipsum" )

        val call = object : Call<LyricsResponse> {
        @Throws(IOException::class)
        override fun execute(): Response<LyricsResponse> {
            return Response.success(lyrics)
        }
        override fun enqueue(callback: Callback<LyricsResponse>) { }
        override fun isExecuted(): Boolean {
            return false
        }
        override fun cancel() { }
        override fun isCanceled(): Boolean {
            return false
        }
        override fun clone(): Call<LyricsResponse> {
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

    override fun deleteLyrics(artist: String, title: String): Call<String> {
        val lyrics = "Eminem-Without Me"

        val call = object : Call<String> {
            @Throws(IOException::class)
            override fun execute(): Response<String> {
                return Response.success(lyrics)
            }
            override fun enqueue(callback: Callback<String>) { }
            override fun isExecuted(): Boolean {
                return false
            }
            override fun cancel() { }
            override fun isCanceled(): Boolean {
                return false
            }
            override fun clone(): Call<String> {
                return this
            }
            override fun request(): Request? {
                return null
            }
        }
        return call
    }
}