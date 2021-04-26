package com.example.lablyrics.ui.showLyrics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R

class ShowLyricsActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_showlyrics)
        //textview.setMovementMethod(new ScrollingMovementMethod())
    }


}