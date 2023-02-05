package com.example.movieapp.fragment

import android.os.Bundle
import android.text.Html
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
import com.example.movieapp.ui.TheatreSelectionView
import com.example.movieapp.viewmodel.CalendarAdapter
import com.example.movieapp.viewmodel.TheatreAdapter
import kotlin.collections.ArrayList

class TheatreSelection : Fragment() {

    private  var _binding : FragmentTheatreSelectionBinding?=null
    private  val binding get() = _binding!!

    val theatreSelectionView : TheatreSelectionView = TheatreSelectionView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTheatreSelectionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        theatreSelectionView.workWithListener(view, binding)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}