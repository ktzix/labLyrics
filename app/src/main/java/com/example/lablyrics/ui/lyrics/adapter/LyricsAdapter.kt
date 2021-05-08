package com.example.lablyrics.ui.lyrics.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lablyrics.R
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.ui.lyrics.LyricsActivity

class LyricsAdapter(private var activity: LyricsActivity): RecyclerView.Adapter<LyricsAdapter.ViewHolder>() {

    inner class ViewHolder(lyricsView: View) : RecyclerView.ViewHolder(lyricsView){

        val tvSong: TextView = lyricsView.findViewById(R.id.tvSong)
        val btnDelete: Button = lyricsView.findViewById(R.id.btnDelete)

    }



    val lyricsList = mutableListOf<Lyrics>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val lyrics = lyricsList[position]
        val _song = lyrics.artist + " - " + lyrics.title
        holder.tvSong.text = _song

        holder.btnDelete.setOnClickListener{
            removeLyrics(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return lyricsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lyrics_row, parent, false)
        return ViewHolder(view)
    }

    fun removeLyrics(position: Int) {

        lyricsList.removeAt(position)
        notifyItemRemoved(position)
        activity.delLyrics(lyricsList[position])

    }
    fun setLyrics(lyrics: List<Lyrics>) {
        this.lyricsList.clear()
        this.lyricsList.addAll(lyrics)
        notifyDataSetChanged()
    }

}