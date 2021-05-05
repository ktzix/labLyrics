package com.example.lablyrics.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.di.LyricsApplication
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import javax.inject.Inject

class SearchActivity: AppCompatActivity(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    private lateinit var title: String
    private lateinit var artist: String

    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("hibaoka333", "hiba")
        super.onCreate(savedInstanceState)

        Log.d("hibaoka222", "hiba")
       binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("hibaoka111", "hiba")
        (applicationContext as LyricsApplication).injector.inject(this)
        Log.d("hibaoka", "hiba")

        binding.btnSearch.setOnClickListener {
            searchPresenter.getLyrics(
                binding.etSongName.text.toString(),
                binding.etArtist.text.toString()
            )
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


    override fun showSearch(lyrics: LyricsResponse) {
        binding.tvResult.text = lyrics.lyrics
    }

    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
        binding.tvResult.text = "hiba lettem"
    }


}