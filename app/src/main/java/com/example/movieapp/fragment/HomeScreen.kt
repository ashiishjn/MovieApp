package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.ui.HomeScreenView

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

        val city_names = resources.getStringArray(R.array.city_names)

        val spinner = binding.spinnerCitySelect
        if (spinner != null) {
            val adapter = ArrayAdapter(view.context, R.layout.custom_spinner_layout, city_names)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}