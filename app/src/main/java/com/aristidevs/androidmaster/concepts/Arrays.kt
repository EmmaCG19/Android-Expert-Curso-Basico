package com.aristidevs.androidmaster.concepts


fun main() {
    daysWithArray(7)
}

//Arrays
fun daysWithArray(dayNumber: Byte) {
    val days =
        arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "DOMINGOOL")

    if (dayNumber in 1..days.size) {
        println(days[dayNumber - 1])
    } else {
        println("No es un día válido")
    }
}

