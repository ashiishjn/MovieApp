package com.example.movieapp.api

import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieResponse
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET


interface MovieAPI {
    @GET("/749b45fa138bc041f066")
     suspend fun getMovies():Response<List<Movie>>
}