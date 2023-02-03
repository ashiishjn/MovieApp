package com.example.movieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.HomeScreenPosterModel
import com.example.movieapp.viewmodel.RecyclerViewAdapterHomeScreen


class HomeScreenActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_screen_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val city_names = resources.getStringArray(R.array.city_names)

        val spinner = view.findViewById<Spinner>(R.id.spinner_city_select)
        if (spinner != null) {
            val adapter = ArrayAdapter(view.context, R.layout.custom_spinner_layout, city_names)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val movie_poster_recycler_view : RecyclerView = view.findViewById(R.id.movie_poster_recycler_view)

        val posterArrayList : ArrayList<HomeScreenPosterModel> = ArrayList()

        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 8.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 8.3f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 7.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 5.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 6.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 9.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 8.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 8.3f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 7.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 5.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 6.5f))
        posterArrayList.add(HomeScreenPosterModel(R.drawable.pathaan_poster_portrait, 9.5f))

        val recyclerViewAdapterHomeScreen : RecyclerViewAdapterHomeScreen =
            RecyclerViewAdapterHomeScreen(posterArrayList, view.context)

        val layoutManager = GridLayoutManager(view.context, 2)

        movie_poster_recycler_view.setLayoutManager(layoutManager);
        movie_poster_recycler_view.setAdapter(recyclerViewAdapterHomeScreen);
    }
}