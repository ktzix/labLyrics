package com.example.lablyrics.ui.lyrics.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LyricsAdapter(private val context: Context) : RecyclerView.Adapter<LyricsAdapter.ViewHolder>() {

    //val lyricsList = mutableListOf<Lyrics>()

    inner class ViewHolder(cityView: View) : RecyclerView.ViewHolder(cityView) {
        //val tvCityName = cityView.tvCityName
        //val cardView = cityView.cardView
        //val btnDelete = cityView.btnDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //val view = LayoutInflater.from(context).inflate()
        //return ViewHolder(view)
        TODO()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    /*


    fun addLyrics(lyrics: Lyrics) {}
    fun removeLyrics(position: Int) {}
    fun setLyrics(lyrics: List<Lyrics>) {}
    */
}