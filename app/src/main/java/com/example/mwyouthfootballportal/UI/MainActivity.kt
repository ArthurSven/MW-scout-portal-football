package com.example.mwyouthfootballportal.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mwyouthfootballportal.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<MaterialButton>(R.id.startButton)

        startButton.setOnClickListener {
            Intent(this, LandingActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}