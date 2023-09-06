package com.aristidevs.androidmaster.apps.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setupUI()
    }

    private fun setupUI() {
        navigateToFirstApp()
    }

    private fun navigateToFirstApp() {
        val firstApp = findViewById<AppCompatButton>(R.id.firstApp)
        firstApp.setOnClickListener {
            Intent(this, FirstAppActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}