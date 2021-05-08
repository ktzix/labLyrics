package com.example.lablyrics.ui.showLyrics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.databinding.ActivityShowlyricsBinding
import com.example.lablyrics.di.LyricsApplication
import com.example.lablyrics.model.LyricsResponse
import javax.inject.Inject

class ShowLyricsActivity: AppCompatActivity(), ShowLyricsScreen{

    @Inject
    lateinit var showLyricsPresenter: ShowLyricsPresenter

    lateinit var binding: ActivityShowlyricsBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityShowlyricsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as LyricsApplication).injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        showLyricsPresenter.attachScreen(this)

    }

    override fun onStop() {
        showLyricsPresenter.detachScreen()
        super.onStop()
    }


    override fun showSearch(lyrics: LyricsResponse) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: Throwable) {
        TODO("Not yet implemented")
    }


}