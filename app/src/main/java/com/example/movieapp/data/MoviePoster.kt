package com.example.movieapp.data

import com.example.movieapp.R

class MoviePoster {
    fun getPosterId (movie_name : String) : Int {

        return when  {
            movie_name == "pathaan" -> R.drawable.pathaan
            movie_name == "Almost pyaar with dj mohabbat" -> R.drawable.almost_pyaar_with_dj_mohabbat
            movie_name == "Avatar: The Way of Water" -> R.drawable.avatar
            movie_name == "Daman" -> R.drawable.daman
            movie_name == "Kali Jotta" -> R.drawable.kali_jotta
            movie_name == "Knock at the cabin" -> R.drawable.knock_at_the_cabin
            movie_name == "The woman king" -> R.drawable.the_woman_king
            movie_name == "Valvi" -> R.drawable.valvi
            movie_name == "Varisu" -> R.drawable.varisu
            movie_name == "Ved" -> R.drawable.ved
            movie_name == "Writer" -> R.drawable.writer
            movie_name == "The Whale" -> R.drawable.the_whale
            else -> R.drawable.pathaan
        }

    }
}