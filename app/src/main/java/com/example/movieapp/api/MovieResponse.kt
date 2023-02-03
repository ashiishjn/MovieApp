package com.example.movieapp.api

import com.example.movieapp.model.Movie

data class MovieResponse(
    val movies: List<Movie>
) {
}