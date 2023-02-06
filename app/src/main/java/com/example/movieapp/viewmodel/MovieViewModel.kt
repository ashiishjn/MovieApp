package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.respository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private  val movieRepository:MovieRepository) :ViewModel(){

    val moviesLiveData get() = movieRepository.moviesLiveData

    fun getMovies()
    {
        viewModelScope.launch {
            movieRepository.getMovies()
        }
    }

}