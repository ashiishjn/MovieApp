package com.example.movieapp.ui

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.PushDataIntoCalendarModel
import com.example.movieapp.data.PushDataIntoTheatreModel
import com.example.movieapp.databinding.FragmentTheatreSelectionBinding
import com.example.movieapp.model.CalendarModel
import com.example.movieapp.model.Theatre_P
import com.example.movieapp.adapter.CalendarAdapter
import com.example.movieapp.adapter.TheatreAdapter
import com.example.movieapp.data.Constants

class TheatreSelectionView {

    val pushDataIntoCalendarModel : PushDataIntoCalendarModel = PushDataIntoCalendarModel()
    val pushDataIntoTheatreModel : PushDataIntoTheatreModel = PushDataIntoTheatreModel()

    fun workWithListener(view : View, binding : FragmentTheatreSelectionBinding) {

        binding.movieName.text = Constants.movie_name

        val calendarArrayList : ArrayList<CalendarModel> = pushDataIntoCalendarModel.pushData()

        val calendarAdapter : CalendarAdapter =
            CalendarAdapter(calendarArrayList, view.context)

        val layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        binding.calendarRecyclerView.setLayoutManager(layoutManager);
        binding.calendarRecyclerView.setAdapter(calendarAdapter);

        // -------------------------------------------------------------------------------------------------------

//        val theatreArrayList : ArrayList<Theatre_P> = pushDataIntoTheatreModel.pushData()
//
//        //val theatreAdapter : TheatreAdapter = TheatreAdapter(theatreArrayList, view.context)
//
//        val theatreLayoutManager = LinearLayoutManager(view.context)
//
//        binding.theatreRecyclerView.layoutManager = theatreLayoutManager
//        binding.theatreRecyclerView.adapter = theatreAdapter

        // -------------------------------------------------------------------------------------------------------

        binding.theatreSelectionBackArrow.setOnClickListener {
            view.findNavController().navigate(R.id.action_theatreSelection_to_movieDescription)
        }

    }
}