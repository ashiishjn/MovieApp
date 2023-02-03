package com.example.movieapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val name: String,
    val rating: String,
    val description: String,
    val genre: String,
    val length: String,
    val time: String,
    val poster: Int,
    val theatreList: MutableList<Theatre>,
) : Parcelable