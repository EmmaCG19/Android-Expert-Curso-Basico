package com.aristidevs.androidmaster.apps.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.firstapp.FirstAppActivity
import com.aristidevs.androidmaster.apps.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setupUI()
    }

    private fun setupUI() {
        navigateToFirstApp()
        navigateToImcApp()
    }

    private fun navigateToImcApp() {
        val btnImcApp = findViewById<AppCompatButton>(R.id.btnImcApp)
        btnImcApp.setOnClickListener {
            Intent(this, ImcCalculatorActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun navigateToFirstApp() {
        val firstApp = findViewById<AppCompatButton>(R.id.btnFirstApp)
        firstApp.setOnClickListener {
            Intent(this, FirstAppActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}