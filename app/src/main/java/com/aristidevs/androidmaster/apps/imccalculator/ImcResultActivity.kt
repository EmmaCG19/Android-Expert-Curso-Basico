package com.aristidevs.androidmaster.apps.imccalculator

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.imccalculator.ImcCalculatorActivity.Companion.IMC_RESULT_KEY


class ImcResultActivity : AppCompatActivity() {

    companion object {
        const val INVALID_IMC = -1.0
    }

    private lateinit var tvIMCResult: TextView
    private lateinit var tvIMCDescription: TextView
    private lateinit var tvIMCStatus: TextView
    private lateinit var btnRecalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        val result: Double = intent.extras?.getDouble(IMC_RESULT_KEY) ?: INVALID_IMC
        initComponents()
        initListeners()
        initUI(result)
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {
            onBackPressed() //Vuelve a la activity anterior
        }
    }

    private fun initComponents() {
        tvIMCResult = findViewById(R.id.tvIMCResult)
        tvIMCDescription = findViewById(R.id.tvIMCDescription)
        tvIMCStatus = findViewById(R.id.tvIMCStatus)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(result: Double) {
        lateinit var imcStatus: String
        lateinit var imcDescription: String
        var statusColor: Int = 0

        when (result) {
            in 0.0..18.4 -> { //Bajo peso
                imcStatus = getString(R.string.low_status)
                imcDescription = getString(R.string.low_description)
                statusColor = R.color.low_imc
            }

            in 18.5..24.9 -> { //Normal
                imcStatus = getString(R.string.normal_status)
                imcDescription = getString(R.string.normal_description)
                statusColor = R.color.normal_imc
            }

            in 25.0..29.9 -> { //Sobrepeso
                imcStatus = getString(R.string.overweight_status)
                imcDescription = getString(R.string.overweight_description)
                statusColor = R.color.overweight_imc
            }

            in 30.0..99.9 -> { //Obesidad
                imcStatus = getString(R.string.obesity_status)
                imcDescription = getString(R.string.obesity_status)
                statusColor = R.color.obesity_imc
            }

            else -> { //Error
                imcStatus = getString(R.string.error)
                imcDescription = getString(R.string.error)
                statusColor = R.color.error_imc
            }
        }

        tvIMCResult.text = if (result != INVALID_IMC) result.toString() else "Error"
        tvIMCDescription.text = imcDescription
        tvIMCStatus.text = imcStatus
        tvIMCStatus.setTextColor(ContextCompat.getColor(this, statusColor))
    }

}