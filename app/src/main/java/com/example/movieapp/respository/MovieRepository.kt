package com.example.movieapp.respository

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.api.MovieAPI
import com.example.movieapp.model.Movie
import com.example.movieapp.utils.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieAPI ) {

    private val _moviesLiveData = MutableLiveData< NetworkResult<List<Movie>>>()
    val moviesLiveData get() = _moviesLiveData

//    private val _statusLiveData = MutableLiveData<NetworkResult<Pair<Boolean, String>>>()
//    val statusLiveData get() = _statusLiveData

    suspend fun getMovies() {
        moviesLiveData.postValue(NetworkResult.Loading())
        val response = movieAPI.getMovies()
        if (response.isSuccessful && response.body() != null) {
            moviesLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            moviesLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        } else {
            moviesLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    }


}