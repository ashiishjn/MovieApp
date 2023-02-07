package com.example.movieapp.fragment

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
import com.example.movieapp.utils.NetworkResult
import com.example.movieapp.viewmodel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlin.collections.ArrayList
@AndroidEntryPoint
class TheatreSelection : Fragment() {

    private  var _binding : FragmentTheatreSelectionBinding?=null
    private  val binding get() = _binding!!

    private val theatreSelectionViewModel by viewModels<TheatreSelectionViewModel>()

    private lateinit var adapter:TheatreAdapter

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
        theatreSelectionViewModel.getMovieListings()
        adapter= TheatreAdapter()

        binding.theatreRecyclerView.layoutManager=LinearLayoutManager(view.context)
        binding.theatreRecyclerView.adapter=adapter
        bindObservers()

    }

    private fun bindObservers() {
        theatreSelectionViewModel.moviesListingLiveData.observe(viewLifecycleOwner, Observer{
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
                    Log.d("Application",theatreSelectionViewModel.moviesListingLiveData.toString())

                    adapter.submitList(it.data)
                }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}