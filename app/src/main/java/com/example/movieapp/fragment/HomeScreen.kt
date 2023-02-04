package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.HomeScreenView
import com.example.movieapp.viewmodel.MovieListAdapter

class HomeScreen : Fragment() {

    val homeScreenView : HomeScreenView = HomeScreenView()

    private  var _binding : FragmentHomeScreenBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHomeScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeScreenView.workWithListener(view, binding)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}