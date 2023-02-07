package com.example.movieapp.di

import com.example.movieapp.api.MovieAPI
import com.example.movieapp.api.MovieListingAPI
import com.example.movieapp.model.MovieListingResponse
import com.example.movieapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideMovieAPI(retrofitBuilder: Retrofit.Builder): MovieAPI {
        return retrofitBuilder.build().create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieListingAPI(retrofitBuilder: Retrofit.Builder):MovieListingAPI{
        return retrofitBuilder.build().create(MovieListingAPI::class.java)

    }

}