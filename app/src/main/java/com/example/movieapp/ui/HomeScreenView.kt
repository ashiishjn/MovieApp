package com.example.movieapp.ui

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding
import com.example.movieapp.model.Movie
import com.example.movieapp.viewmodel.MovieListAdapter

class HomeScreenView {
    fun workWithListener(view : View, binding: FragmentHomeScreenBinding) {
        val city_names = view.context.resources.getStringArray(R.array.city_names)

        val spinner = binding.spinnerCitySelect
        if (spinner != null) {
            val adapter = ArrayAdapter(view.context, R.layout.custom_spinner_layout, city_names)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    // write code to perform some action
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val movieList : ArrayList<Movie> = ArrayList()

        val movieListAdapter : MovieListAdapter =
            MovieListAdapter(movieList, view.context)

        val layoutManager = GridLayoutManager(view.context, 2)

        binding.moviePosterRecyclerView.setLayoutManager(layoutManager);
        binding.moviePosterRecyclerView.setAdapter(movieListAdapter);

        binding.homeScreenLogOut.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeScreen_to_signIn)
        }
    }
}