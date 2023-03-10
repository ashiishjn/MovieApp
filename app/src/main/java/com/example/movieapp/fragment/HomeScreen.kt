package com.example.movieapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding
import com.example.movieapp.ui.HomeScreenView
import com.example.movieapp.utils.NetworkResult
import com.example.movieapp.adapter.MovieListAdapter
import com.example.movieapp.model.Movie
import com.example.movieapp.viewmodel.MovieViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreen : Fragment() {

    val homeScreenView : HomeScreenView = HomeScreenView()

    private  var _binding : FragmentHomeScreenBinding?=null
    private  val binding get() = _binding!!

    private val movieViewModel by viewModels<MovieViewModel>()

    private lateinit var adapter: MovieListAdapter

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

        movieViewModel.getMovies()
        adapter= MovieListAdapter(::onNoteClicked)

      //  Log.d("Application","sucess()")

        binding.moviePosterRecyclerView.layoutManager=GridLayoutManager(view.context, 2)
        binding.moviePosterRecyclerView.adapter=adapter
        bindObservers()
    }

    private fun bindObservers() {
        movieViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer{
            when(it){
                is NetworkResult.Loading ->{
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT)
                        .show()

                }
                is NetworkResult.Success -> {
                    Log.d("Application",movieViewModel.moviesLiveData.toString())

                    adapter.submitList(it.data)
                }
            }
        })
    }

    private fun onNoteClicked(movie: Movie){
        val bundle = Bundle()
        bundle.putString("movie", Gson().toJson(movie))
        findNavController().navigate(R.id.action_homeScreen_to_movieDescription, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}