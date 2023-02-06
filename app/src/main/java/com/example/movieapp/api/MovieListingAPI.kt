package com.example.movieapp.api

import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieListingResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieListingAPI {
    @GET("/1ad47e47a0db1f0ad212")
    suspend fun getMovieListings(): Response<List<MovieListingResponse>>
}