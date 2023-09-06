package com.aristidevs.androidmaster.exercises.google

/*
Exercise 5: Song catalog

Imagine that you need to create a music-player app.

Create a class that can represent the structure of a song. The Song class must include these code elements:

Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:

"[Title], performed by [artist], was released in [year published]."
*/

class Song
(
    val title: String,
    val artist: String,
    val yearPublished: Short,
    val playCount: Long
) {
    var isPopular = if (playCount >= 1000) "Popular" else "Unpopular"
    val songDescription: () -> Unit = {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    val song = Song("Musica Ligera", "Soda Estereo", 1990, 350000)
    song.songDescription()
    println(song.isPopular)
}
