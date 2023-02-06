package com.example.movieapp.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieCardBinding
import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieResponse


//class MovieListAdapter() :
//    ListAdapter<MovieListAdapter.RecyclerViewHolder,() {
//
//    private val posterList: MutableLiveData<Movie>
//    private val mcontext: Context
//
//    init {
//        posterList = recyclerDataArrayList
//        this.mcontext = mcontext
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
//        // Inflate Layout
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.custom_home_screen_recycler_view_layout, parent, false)
//        return RecyclerViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//        // Set the data to textview and imageview.
//        val recyclerData: Movie = posterList.value
//
////        holder.rating.text = recyclerData.rating.toString() + "/10"
////        holder.poster.setImageResource(recyclerData.image)
//
//    }
//
//    override fun getItemCount(): Int {
//        // this method returns the size of recyclerview
//        return posterList.size
//    }
//
//    // View Holder Class to handle Recycler View.
//    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val rating: TextView = itemView.findViewById(R.id.home_screen_movie_rating)
//        val poster: ImageView = itemView.findViewById(R.id.home_screen_movie_poster_image)
//    }
//
//}
class MovieListAdapter() :
    ListAdapter<Movie,MovieListAdapter.MovieViewHolder>(ComparatorDiffUtil()) {

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
            binding.homeScreenMovieRating.text = movie.title
            binding.homeScreenMoviePosterImage.setImageResource(R.drawable.pathaan_poster_portrait)
            binding.root.setOnClickListener {
                val navController = Navigation.findNavController(binding.root)
                navController.navigate(R.id.action_homeScreen_to_movieDescription)
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