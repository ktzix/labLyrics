package com.example.lablyrics.model

import com.google.gson.annotations.SerializedName


data class LyricsResponse (

    @SerializedName("lyrics")
    val lyrics : String
)