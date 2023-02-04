package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding
import com.example.movieapp.databinding.FragmentSeatsSelectionBinding
import com.example.movieapp.ui.SeatSelectionView

class SeatsSelection : Fragment() {

    val seatSelectionView : SeatSelectionView = SeatSelectionView()

    private  var _binding : FragmentSeatsSelectionBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSeatsSelectionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        seatSelectionView.workWithListener(view, binding)
    }

}