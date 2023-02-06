package com.example.movieapp.respository

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.api.MovieAPI
import com.example.movieapp.api.MovieListingAPI
import com.example.movieapp.model.MovieListingResponse
import com.example.movieapp.model.Theatre_P
import com.example.movieapp.utils.MovieListingHelper
import com.example.movieapp.utils.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class MovieListingRepository @Inject constructor(private val movieListingAPI: MovieListingAPI ) {

    private val _moviesListingLiveData = MutableLiveData< NetworkResult<List<Theatre_P>>>()
    val moviesListingLiveData get() = _moviesListingLiveData

//    private val _statusLiveData = MutableLiveData<NetworkResult<Pair<Boolean, String>>>()
//    val statusLiveData get() = _statusLiveData


    suspend fun getMovieListings() {
        moviesListingLiveData.postValue(NetworkResult.Loading())
        val response = (movieListingAPI.getMovieListings())
        if (response.isSuccessful && response.body() != null) {
            moviesListingLiveData.postValue(NetworkResult.Success(MovieListingHelper().ListToOrganisedList(response.body()!!)))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            moviesListingLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        } else {
            moviesListingLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    }
}