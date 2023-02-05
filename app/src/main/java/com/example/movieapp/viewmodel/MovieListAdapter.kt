package com.example.movieapp.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.Movie


class MovieListAdapter(recyclerDataArrayList: ArrayList<Movie>, mcontext: Context) :
    RecyclerView.Adapter<MovieListAdapter.RecyclerViewHolder>() {

    private val posterList: ArrayList<Movie>
    private val mcontext: Context

    init {
        posterList = recyclerDataArrayList
        this.mcontext = mcontext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_home_screen_recycler_view_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData: Movie = posterList[position]
//        holder.rating.text = recyclerData.rating.toString() + "/10"
//        holder.poster.setImageResource(recyclerData.image)
    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return posterList.size
    }

    // View Holder Class to handle Recycler View.
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rating: TextView = itemView.findViewById(R.id.home_screen_movie_rating)
        val poster: ImageView = itemView.findViewById(R.id.home_screen_movie_poster_image)
    }
}