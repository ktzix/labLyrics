package com.example.lablyrics.ui.lyrics

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.databinding.ActivityLyricsBinding
import com.example.lablyrics.di.LyricsApplication
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.ui.lyrics.adapter.LyricsAdapter
import javax.inject.Inject

class LyricsActivity : AppCompatActivity(), LyricsScreen {

    @Inject
    lateinit var lyricsPresenter: LyricsPresenter

    lateinit var lyricsAdapter : LyricsAdapter

    private lateinit var binding : ActivityLyricsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLyricsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as LyricsApplication).injector.inject(this)
        initRecyclerView()

    }

    override fun onStart() {
        super.onStart()
        lyricsPresenter.attachScreen(this)

    }

    override fun onStop() {
        lyricsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        lyricsAdapter = LyricsAdapter(this)
        binding.listSongs.adapter = lyricsAdapter
        lyricsPresenter.getLyrics()
    }

    override fun showLyricsList(lyricsList: List<Lyrics>) {
        this@LyricsActivity.runOnUiThread{
            lyricsAdapter.setLyrics(lyricsList)
        }

    }

    override fun showDeleteSucces(song: String) {
        Toast.makeText(
            applicationContext,
            "$song torolve",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
    }

    fun delLyrics(lyrics: Lyrics){
        lyricsPresenter.delLyrics(lyrics)
    }


}