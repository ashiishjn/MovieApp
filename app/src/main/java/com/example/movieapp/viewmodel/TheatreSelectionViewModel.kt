package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.respository.MovieListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TheatreSelectionViewModel @Inject constructor(private  val movieListingRepository: MovieListingRepository) :ViewModel(){

    val moviesListingLiveData get()=movieListingRepository.moviesListingLiveData

    fun getMovieListings()
    {
        viewModelScope.launch {
            movieListingRepository.getMovieListings()
        }
    }




}