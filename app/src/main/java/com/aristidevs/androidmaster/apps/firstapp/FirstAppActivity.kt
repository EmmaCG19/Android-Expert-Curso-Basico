package com.aristidevs.androidmaster.apps.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.ButtonBarLayout
import com.aristidevs.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        setupUI()
    }

    private fun setupUI() {
        val etInput = findViewById<AppCompatEditText>(R.id.etInput)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val name = etInput.text.toString()
            if (name.isNotEmpty()) {

                //Creating Intent
                Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    startActivity(this)
                }

            }
        }

    }

}

