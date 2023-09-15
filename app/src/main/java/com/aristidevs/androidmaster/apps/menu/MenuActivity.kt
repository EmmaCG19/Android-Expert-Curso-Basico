package com.aristidevs.androidmaster.apps.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.firstapp.FirstAppActivity
import com.aristidevs.androidmaster.apps.imccalculator.ImcCalculatorActivity
import com.aristidevs.androidmaster.apps.todoapp.TodoAppActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var firstApp: AppCompatButton
    private lateinit var btnImcApp: AppCompatButton
    private lateinit var btnTODOApp: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnTODOApp = findViewById(R.id.btnTODOApp)
        btnImcApp = findViewById(R.id.btnImcApp)
        firstApp = findViewById(R.id.btnFirstApp)
    }

    private fun initListeners() {
        btnTODOApp.setOnClickListener {
            navigateToTODOApp()

        }

        btnImcApp.setOnClickListener {
            navigateToImcApp()
        }

        firstApp.setOnClickListener {
            navigateToFirstApp()
        }
    }

    private fun navigateToTODOApp() {
        Intent(this, TodoAppActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun navigateToImcApp() {
        Intent(this, ImcCalculatorActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun navigateToFirstApp() {
        Intent(this, FirstAppActivity::class.java).apply {
            startActivity(this)
        }
    }
}