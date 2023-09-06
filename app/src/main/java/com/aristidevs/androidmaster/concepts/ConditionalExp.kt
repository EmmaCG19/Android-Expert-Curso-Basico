package com.aristidevs.androidmaster

import kotlin.random.Random.Default.nextBoolean

private const val LEGAL_AGE = 18

fun main() {
    getResult(false)
}

//AND, OR, NOT
fun canIDrink(age: Int) {
    val parents_permission: Boolean = nextBoolean()

    if (!(age >= LEGAL_AGE && parents_permission) || (age < LEGAL_AGE)) {
        println("You can't drink, try again")
    } else {
        println("You can drink, congrats!")
    }
}

//IF
fun nameStartsWithA(name: String) {

    //Empty or null text validation
    if (name.trim().isNotEmpty()) {
        val firstLetter: Char = name[0].uppercase().first()

        if (firstLetter == 'A') {
            println("Tu nombre empieza con A")
        } else if (firstLetter == 'B') {
            println("Tu nombre empieza con B")
        } else {
            println("Tu nombre NO empieza ni con A o B")
        }

    } else {
        println("Debe ingresar un nombre válido")
    }
}


//Note: In this example, it's recommended to use a data structure as arrays (index) or map (key/value)

//1) WHEN: Simple
fun getMonth(month: Int): String {

    return when (month) {
        1 -> {
            "Enero"
        }

        2 -> {
            "Febrero"
        }

        3 -> {
            "Marzo"
        }

        4 -> {
            "Abril"
        }

        5 -> {
            "Mayo"
        }

        6 -> {
            "Junio"
        }

        7 -> {
            "Julio"
        }

        8 -> {
            "Agosto"
        }

        9 -> {
            "Septiembre"
        }

        10 -> {
            "Octubre"
        }

        11 -> {
            "Noviembre"
        }

        12 -> {
            "Diciembre"
        }

        else -> {
            "No es un mes válido"
        }
    }

}

//2) WHEN: Secuencias
fun getTrimestre(month: Int) =
    when (month) {
        1, 2, 3 -> "Primer trimestre"
        4, 5, 6 -> "Segundo trimestre"
        7, 8, 9 -> "Tercer trimestre"
        10, 11, 12 -> "Cuarto trimestre"
        else -> "Mes no es válido"
    }

//3) WHEN: Rangos con IN A..B
fun getSemestre(month: Int) =
    when (month) {
        in 1..6 -> "Primer semestre"
        in 7..12 -> "Segundo semestre"
        !in 1..12 -> "Mes no es válido"
        else -> "No se porque me pide el else si ya use el !in"
    }

//4) WHEN: Check type with IS
fun getResult(value: Any) {
    when (value) {
        is Int -> value + value
        is String -> println("Es un string '${value}'")
        is Boolean -> if (value) println("Verdadero") else println("Falso")
    }
}