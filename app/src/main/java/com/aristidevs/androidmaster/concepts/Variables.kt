package com.aristidevs.androidmaster

import java.nio.DoubleBuffer
import java.util.Calendar

//Global variable
val globalVar: String = "Esto es una variable global"

fun main() {
    showMyInfo(15, 6, 1994)
}

fun variablesNumericas() {
    //Byte -128 a 127
    val byteExample: Byte = 127

    //Short -32xxx a 32xxxx
    val shortExample: Short = 32600

    //Int -2,147,483,647 a 2,147,483,647
    val intExample: Int = 30

    //Long -9,223,372,036,854,775,807 a 9,223,372,036,854,775,807
    val longExample: Long = 30

    //Float - Soporta hasta 6 decimales
    val floatExample: Float = 30.5f

    //Double - Soporta hasta 14 decimales
    val doubleExample: Double = 3241.31

    /*Asignar*/

    val myVariable1: Int = 24
    //myVariable = 30 --Error
    println(myVariable1)

    var myVariable2: Int = 30
    myVariable2 = 4
    println(myVariable2)


    /*Convertir tipo*/
    var exampleSuma1: Float =
        floatExample + myVariable1 //El compilador convierte el Int a Float de forma implicita
    var exampleSuma2: Int =
        floatExample.toInt() + myVariable1 //Se convierte el tipo de float a Int de forma explicita

    println(exampleSuma1)
    println(exampleSuma2)

    /*Operaciones*/

    //Modulo
    println(myVariable1 % myVariable2)
}


fun variablesAlfanumericas() {
    //Char
    val charExample1: Char = 'e'
    val charExample2: Char = '2'
    val charExample3: Char = '@'

    //String
    val stringExample: String = "AristiDevs"

    //Boolean
    val booleanExample1: Boolean = true //1
    val booleanExample2: Boolean = false //0

    println("The message result is: ${stringExample.uppercase()}")

    //Concatenar
    val newText: String = "Probando la concatenacion"
    println("$stringExample está ${newText.lowercase()} y se suma '$globalVar'")

}

//Funciones
fun showMyInfo(
    day: Int,
    month: Int,
    year: Int,
    name: String = "Emmanuel", //Default argument
    lastName: String = "Fernandez"
) {
    println(getFullName(name, lastName))
    println(getBirthday(day,month,year))
}


//Date
fun getBirthday(day: Int, month: Int, year: Int): String {
    val calendar: Calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    return "Tengo ${currentYear - year} años y cumplo el $day/$month/$year"
}

fun getFullName(name: String, lastName: String): String {
    return "$name, $lastName"
}
