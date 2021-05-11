package com.example.lablyrics.ui.about

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lablyrics.R
import com.example.lablyrics.databinding.ActivityAboutBinding
import com.example.lablyrics.databinding.ActivitySearchBinding
import com.example.lablyrics.ui.search.SearchActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics

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

        FirebaseApp.initializeApp(applicationContext);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);

        val crashButton = Button(this)
        crashButton.text = "Crash!"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))

    }
}