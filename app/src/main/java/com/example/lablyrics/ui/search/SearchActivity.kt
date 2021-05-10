package com.example.lablyrics.ui.search

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.di.LyricsApplication
import com.example.lablyrics.interactor.DBInteractor
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.repository.database.AppDatabase
import com.example.lablyrics.ui.lyrics.LyricsActivity
import com.example.lablyrics.ui.lyrics.adapter.LyricsAdapter
import javax.inject.Inject

class SearchActivity: AppCompatActivity(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    private lateinit var title: String
    private lateinit var artist: String

    private lateinit var binding : ActivitySearchBinding

    private lateinit var newSong : Lyrics

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


       binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        (applicationContext as LyricsApplication).injector.inject(this)

        binding.tvResult.movementMethod =  ScrollingMovementMethod()

        binding.btnSearch.setOnClickListener {
            searchPresenter.getLyrics(
                binding.etSongName.text.toString(),
                binding.etArtist.text.toString()
            )
        }

        binding.btnFavs.setOnClickListener {
            val intent = Intent(applicationContext, LyricsActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddFav.setOnClickListener {
                saveLyrics()
        }

    }

    override fun onStart() {
        super.onStart()
        searchPresenter.attachScreen(this)


    }

    override fun onStop() {
        searchPresenter.detachScreen()
        super.onStop()
    }


    override fun showSearch(lyrics: LyricsResponse?) {
        binding.tvResult.text = lyrics!!.lyrics
    }

    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
        binding.tvResult.text = "hiba lettem"
    }

    override fun showAddSucces(lyrics: Lyrics?) {
        this@SearchActivity.runOnUiThread{ Toast.makeText(
            applicationContext,
            "${lyrics?.artist}-${lyrics?.title} hozzaadva a kedvencekhez",
            Toast.LENGTH_SHORT
        ).show()
    }}

    fun saveLyrics(){
        Thread{

            searchPresenter.addLyricsToDB( Lyrics(
               artist = binding.etArtist.text.toString(),
                title = binding.etSongName.text.toString(),
               text = binding.tvResult.text.toString()))

        }.start()
    }

}