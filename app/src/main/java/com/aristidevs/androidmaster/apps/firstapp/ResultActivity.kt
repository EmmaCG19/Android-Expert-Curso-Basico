package com.aristidevs.androidmaster.apps.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.aristidevs.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setupUI()

    }

    private fun setupUI() {
        val tvName = findViewById<TextView>(R.id.tvName)

        //Getting intent values
        val name = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvName.text = "HOLA ${name.uppercase()}"
    }
}