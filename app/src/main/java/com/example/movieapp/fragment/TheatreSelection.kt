package com.example.movieapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.PushDataIntoCalendarModel
import com.example.movieapp.data.PushDataIntoTheatreModel
import com.example.movieapp.databinding.FragmentTheatreSelectionBinding
import com.example.movieapp.model.CalendarModel
import com.example.movieapp.model.Theatre_P
import com.example.movieapp.viewmodel.CalendarAdapter
import com.example.movieapp.viewmodel.TheatreAdapter
import kotlin.collections.ArrayList

class TheatreSelection : Fragment() {

    private  var _binding : FragmentTheatreSelectionBinding?=null
    private  val binding get() = _binding!!

    val pushDataIntoCalendarModel : PushDataIntoCalendarModel = PushDataIntoCalendarModel()
    val pushDataIntoTheatreModel : PushDataIntoTheatreModel = PushDataIntoTheatreModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTheatreSelectionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val calendarArrayList : ArrayList<CalendarModel> = pushDataIntoCalendarModel.pushData()

        val calendarAdapter : CalendarAdapter =
            CalendarAdapter(calendarArrayList, view.context)

        val layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL, false)

        binding.calendarRecyclerView.setLayoutManager(layoutManager);
        binding.calendarRecyclerView.setAdapter(calendarAdapter);

        // -------------------------------------------------------------------------------------------------------

        val theatreArrayList : ArrayList<Theatre_P> = pushDataIntoTheatreModel.pushData()

        val theatreAdapter : TheatreAdapter = TheatreAdapter(theatreArrayList, view.context)

        val theatreLayoutManager = LinearLayoutManager(view.context)

        binding.theatreRecyclerView.layoutManager = theatreLayoutManager
        binding.theatreRecyclerView.adapter = theatreAdapter

        // -------------------------------------------------------------------------------------------------------

        binding.theatreSelectionBackArrow.setOnClickListener {
            findNavController().navigate(R.id.action_theatreSelection_to_movieDescription)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}