package com.aristidevs.androidmaster.exercises.google

/*
Exercise 6: Internet profile

Oftentimes, you're required to complete profiles for online websites that contain mandatory and non-mandatory fields.
For example, you can add your personal information and link to other people who referred you to sign up for the profile.
In the initial code provided in the following code snippet, write a program which prints out a person's profile details.

Output:

Name: Amanda
Age: 33
Likes to play tennis. Doesn't have a referrer.

Name: Atiqah
Age: 28
Likes to climb. Has a referrer named Amanda, who likes to play tennis.
*/


fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(
    val name: String,
    val age: Int,
    val hobby: String?,
    val referrer: Person?
) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        //Check nullability
        if (hobby != null) {
            print("Likes to $hobby. ")
        } else {
            print("Doesn't like anything. ")
        }

        if (referrer != null) {
            println("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby ?: "do nothing"}\n")
        } else {
            println("Doesn't have a referrer.\n")
        }
    }
}
