package com.example.lablyrics.ui.about

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivityAboutBinding
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.ui.search.SearchActivity

class AboutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {

            val intent = Intent(applicationContext, SearchActivity::class.java)
                startActivity(intent)
        }
    }
}