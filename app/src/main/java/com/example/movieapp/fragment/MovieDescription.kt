package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.data.MoviePoster
import com.example.movieapp.databinding.FragmentMovieDescriptionBinding
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.model.Movie
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDescription : Fragment() {

    private  var _binding : FragmentMovieDescriptionBinding?=null
    private  val binding get() = _binding!!

    private  var movie:Movie?= null
    val moviePoster : MoviePoster = MoviePoster()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentMovieDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInitialData()
        binding.bookTicketsButton.setOnClickListener {
            findNavController().navigate(R.id.action_movieDescription_to_theatreSelection)
        }

        binding.movieDescriptionBackArrow.setOnClickListener {
            findNavController().navigate(R.id.action_movieDescription_to_homeScreen)
        }
    }

    private fun setInitialData() {
        val jsonNote = arguments?.getString("movie")
        if (jsonNote != null) {
            movie = Gson().fromJson<Movie>(jsonNote, Movie::class.java)
            movie?.let {
                binding.movieName.text = it.title
                binding.movieDescription.text = it.plot
                binding.moviePoster.setImageResource(moviePoster.getPosterId(it.title))
                binding.movieRating.text = it.rating
                binding.movieLength.text = it.runtime
            }
        }
        else{
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}