package com.aristidevs.androidmaster.exercises.google

//Exercise 4: Temperature Converter

/*There are three main temperature scales used in the world: Celsius, Fahrenheit, and Kelvin.

In the initial code provided in the following code snippet, write a program that converts a temperature from one scale to another with these formulas:

Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
Kelvin to Celsius: ° C = K - 273.15
Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
Note that the String.format("%.2f", *//* measurement *//* ) method is used to convert a number into a String type with 2 decimal places.*/

/*Required output:
27.0 degrees Celsius is 80.60 degrees Fahrenheit.
350.0 degrees Kelvin is 76.85 degrees Celsius.
10.0 degrees Fahrenheit is 260.93 degrees Kelvin.*/

private val CELSIUS = "Celsius"
private val FAHRENHEIT = "Fahrenheit"
private val KELVIN = "Kelvin"

fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", fromCelsiusToFahrenheit)
    printFinalTemperature(350.0, "Kelvin", "Celsius", fromKelvinToCelsius)
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fromFahrenheitToKelvin)
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format(
        "%.2f",
        conversionFormula(initialMeasurement)
    ) // print text-number with two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

//Lamba functions
val fromCelsiusToFahrenheit: (Double) -> Double = { celsiusTemp ->
    (9 / 5.0) * celsiusTemp + 32
}

val fromKelvinToCelsius: (Double) -> Double = { kelvinTemp ->
    kelvinTemp - 273.15
}

val fromFahrenheitToKelvin: (Double) -> Double = { fahrenTemp ->
    (5 / 9.0) * (fahrenTemp - 32) + 273.15
}

val fromCelsiusToKelvin: (Double) -> Double = { celsiusTemp ->
    fromFahrenheitToKelvin((fromCelsiusToFahrenheit(celsiusTemp)))
}

val fromKelvinToFahrenheit: (Double) -> Double = { kelvinTemp ->
    fromCelsiusToFahrenheit(fromKelvinToCelsius(kelvinTemp))
}

val fromFahrenheitToCelsius: (Double) -> Double = { fahrenTemp ->
    fromKelvinToCelsius(fromFahrenheitToKelvin(fahrenTemp))
}



