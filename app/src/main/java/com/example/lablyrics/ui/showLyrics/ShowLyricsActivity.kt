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
import java.util.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ShowLyricsActivity: AppCompatActivity(), ShowLyricsScreen{

    @Inject
    lateinit var showLyricsPresenter: ShowLyricsPresenter

    lateinit var binding: ActivityShowlyricsBinding
     var curId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowlyricsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as LyricsApplication).injector.inject(this)

        binding.tvLyrics.movementMethod =  ScrollingMovementMethod()

        curId = intent.getIntExtra("EXTRA_ID", 0)
        Log.d("KAPOTT ERTEK ID", curId.toString())



        Thread{showLyricsPresenter.getLyricsById(curId) }.start()

        binding.btnUpdate.setOnClickListener {
                    showLyricsPresenter.updateLyrics(curId , binding.tvArtist.text.toString(), binding.tvTitle.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        showLyricsPresenter.attachScreen(this)
        showLyricsPresenter.getLyricsById(curId)

    }

    override fun onStop() {
        showLyricsPresenter.detachScreen()
        super.onStop()
    }



    override fun showError(errorMsg: Throwable) {
        errorMsg.printStackTrace()
    }

    override fun showUpdateSucces(song: String?) {
        this@ShowLyricsActivity.runOnUiThread{ Toast.makeText(
            applicationContext,
            "$song Modositva",
            Toast.LENGTH_SHORT
        ).show()
        }
    }

    override fun showGetLyricsByIdSucces(lyrics: Lyrics?) {
        this@ShowLyricsActivity.runOnUiThread{ binding.tvArtist.setText(lyrics?.artist)
        binding.tvTitle.setText(lyrics?.title)
        binding.tvLyrics.text = lyrics?.text
    }}


}