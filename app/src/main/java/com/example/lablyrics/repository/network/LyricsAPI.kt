package com.example.lablyrics.repository.network

import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import retrofit2.Call
import retrofit2.http.*

interface LyricsAPI {

    companion object{
        const val ENDPOINT_URL="https://api.lyrics.ovh/v1/"
    }

    //https://api.lyrics.ovh/v1/Coldplay/Adventure of a Lifetime
    /**
     *
     * Returns a lyrics of given song from given artist.
     * @param artist name of artist
     * @param title name of song
     * @return Call<Lyrics>
    </Void> */
   @GET("{artist}/{title}")
    fun getLyrics(@Path("artist") artist: String, @Path("title") title: String): Call<LyricsResponse>



    /**
     *
     * Update lyrics
     * @param artist name of artist
     * @param title name of song
     * @return Call<Lyrics>
    </Void> */
    @PUT("{artist}/{title}")
    fun putLyrics(@Path("artist") artist: String, @Path("title") title: String, @Body param: Lyrics)
    : Call<Lyrics>


    /**
     *
     * add Lyrics
     * @return Call<Void>
    </Void> */
    @POST("{artist}/{title}")
    fun postLyrics(@Path("artist") artist: String, @Path("title") title: String, @Body param: Lyrics): Call<Int>

    /**
     *
     * Delete lyrics
     * @param artist name of artist
     * @param title name of song
     * @return Call<Void>
    </Void> */
    @DELETE("{artist}/{title}")
    fun deleteLyrics(@Path("artist") artist: String, @Path("title") title: String): Call<String>

}