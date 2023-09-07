package com.aristidevs.androidmaster.apps.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.aristidevs.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import kotlin.math.pow


class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: AppCompatButton

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = true
    private var currentWeight: Int = 70
    private var currentAge: Int = 26
    private var currentHeight: Int = 120

    companion object{
        const val IMC_RESULT_KEY = "IMC_RESULT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
        setHeight()
    }

    private fun setHeight() {
        tvHeight.text = "$currentHeight cm"
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnCalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGenderToMale()
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGenderToFemale()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnAddWeight.setOnClickListener {
            currentWeight++
            setWeight()
            tvWeight.text = currentWeight.toString()
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight--
            setWeight()
        }

        btnAddAge.setOnClickListener {
            currentAge++
            setAge()
        }

        btnSubtractAge.setOnClickListener {
            currentAge--
            setAge()
        }

        btnCalculate.setOnClickListener {
            calculateIMC()
            navigateToResultActivity()
        }

    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    /*TODO: Try to optimize changeGenderToMale / changeGenderToFemale\*/
    private fun changeGenderToMale() {
        isMaleSelected = true
        isFemaleSelected = !isMaleSelected
    }

    private fun changeGenderToFemale() {
        isFemaleSelected = true
        isMaleSelected = !isFemaleSelected
    }


    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
            val color = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        //Return color
        return ContextCompat.getColor(this, color)
    }

    private fun calculateIMC(): Double {
        val imc = currentWeight / ((currentHeight.toDouble() / 100).pow(2))
        val df = DecimalFormat("#.#")
        return df.format(imc).toDouble()
    }

    private fun navigateToResultActivity() {
        Intent(this, ImcResultActivity::class.java).apply {
            putExtra(IMC_RESULT_KEY, calculateIMC())
            startActivity(this)
        }
    }
}
