package com.example.movieapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.data.MoviePoster
import com.example.movieapp.databinding.MovieCardBinding
import com.example.movieapp.model.Movie

class MovieListAdapter(private val onNoteClicked: (Movie) -> Unit) :
    ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(ComparatorDiffUtil()) {

    val moviePoster : MoviePoster = MoviePoster()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        Log.d("Application","Inside List Adapter")
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val note = getItem(position)
        note?.let {
            holder.bind(it)
        }
    }

    inner class MovieViewHolder(private val binding: MovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.homeScreenMovieRating.text = movie.rating

            binding.homeScreenMoviePosterImage.setImageResource(moviePoster.getPosterId(movie.title))
            binding.root.setOnClickListener {
                Constants.movie_name = movie.title
                onNoteClicked(movie)
                 }
        }
    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}