package com.example.movieapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ticket(
    val movie: String,
    val theatre: Theatre,
) : Parcelable