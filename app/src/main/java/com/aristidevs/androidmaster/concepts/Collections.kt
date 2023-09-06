package com.aristidevs.androidmaster.concepts

//Lists

fun main(){
    daysWithInmutableList()
    daysWithMutableList()

}

/*1) Inmutable List (Read-only)*/
fun daysWithInmutableList() {

    val readOnlyList =
        listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo")

    println(readOnlyList.size)
    println(readOnlyList)
    println(readOnlyList[0])
    println(readOnlyList.first())
    println(readOnlyList.last())

    //Filter
    val daysWithM = readOnlyList.filter { day -> day.startsWith('M') }
    println(daysWithM)

    //For-each
    readOnlyList.forEach { weekday -> print("$weekday -") }
}


/*2)Mutable List*/
fun daysWithMutableList() {

        //Mutable List: can add, remove or alter the order of the items after the creation
        //Array List: same as Mutable List, but with better performance

        val days =
            arrayListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo")

        days.add("Osvaldo")
        days.remove("Lunes")
        days.add(0, "ArisDay")
        days.forEach { println(it) }

}

//Map

fun daysWithMap(){

}