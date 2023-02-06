package com.example.movieapp.di

import com.example.movieapp.api.MovieAPI
import com.example.movieapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.text.Typography.dagger

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit =
//        Retrofit.Builder()
//            .baseUrl("Yet to Implement")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()



}