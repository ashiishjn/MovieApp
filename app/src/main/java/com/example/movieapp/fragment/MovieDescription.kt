package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.databinding.FragmentMovieDescriptionBinding
import com.example.movieapp.databinding.FragmentSignInBinding

class MovieDescription : Fragment() {

    private  var _binding : FragmentMovieDescriptionBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentMovieDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.movieName.text = Constants.movie_name
        binding.bookTicketsButton.setOnClickListener {
            findNavController().navigate(R.id.action_movieDescription_to_theatreSelection)
        }

        binding.movieDescriptionBackArrow.setOnClickListener {
            findNavController().navigate(R.id.action_movieDescription_to_homeScreen)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}