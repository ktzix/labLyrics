package com.example.lablyrics.ui.showLyrics

import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.databinding.ActivityShowlyricsBinding
import com.example.lablyrics.di.LyricsApplication
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import javax.inject.Inject

class ShowLyricsActivity: AppCompatActivity(), ShowLyricsScreen{

    @Inject
    lateinit var showLyricsPresenter: ShowLyricsPresenter

    lateinit var binding: ActivityShowlyricsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowlyricsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as LyricsApplication).injector.inject(this)
        binding.tvT.movementMethod = ScrollingMovementMethod()

        val curId = intent.getIntExtra("EXTRA_ID", 0)

        showLyricsPresenter.getLyricsById(curId)


        binding.btnUpdate.setOnClickListener {

                    showLyricsPresenter.updateLyrics(curId , binding.tvA.text.toString(), binding.tvT.text.toString())

        }
    }

    override fun onStart() {
        super.onStart()
        showLyricsPresenter.attachScreen(this)

    }

    override fun onStop() {
        showLyricsPresenter.detachScreen()
        super.onStop()
    }



    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
    }

    override fun showUpdateSucces(song: String) {
        this@ShowLyricsActivity.runOnUiThread{ Toast.makeText(
            applicationContext,
            "$song Modositva",
            Toast.LENGTH_SHORT
        ).show()
        }
    }

    override fun showGetLyricsByIdSucces(lyrics: Lyrics) {
        binding.tvA.setText(lyrics.artist)
        binding.tvT.setText(lyrics.title)
        binding.tvL.text = lyrics.text
    }


}