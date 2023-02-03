package com.example.movieapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Theatre(
    val name: String,
    val location: String
) : Parcelable