package com.aristidevs.androidmaster

fun main() {
    val noNulo: String = "Aris"
    val siNulo: String? = null //?

//    println(noNulo[1])
//    println(siNulo!![1]) /*-> !! permite ejecutar una expresión que puede dar un NullPointerException*/

    //Utilizar el safe operator + elvis operator para indicar que hacer ante un nulo
    println(siNulo?.get(1) ?: "Es nulo, no lo toques que explota todo")
}