package com.example.movieapp.model

data class MovieListingResponse(
    val id: Int,
    val theatre: String,
    val timimg: String,
    val title: String,
    val unavailable_seat: List<Int>
)