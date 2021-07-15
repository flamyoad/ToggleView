package com.flamyoad.toggleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.flamyoad.toggle_view.ToggleView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBookmark = findViewById<ToggleView>(R.id.btnBookmark)

//        btnBookmark.setOnClickListener {
//            viewModel.toggleBookmarkStatus()
//        }
//
//        viewModel.bookmarkStatus().observe(this) {
//            btnBookmark.isChecked = it
//        }
    }
}