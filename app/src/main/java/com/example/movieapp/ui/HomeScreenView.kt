package com.example.movieapp.ui

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeScreenBinding

class HomeScreenView {
    fun workWithListener(view : View, binding: FragmentHomeScreenBinding) {
        val city_names = view.context.resources.getStringArray(R.array.city_names)

        val adapter = ArrayAdapter(view.context, R.layout.custom_spinner_layout, city_names)
        binding.spinnerCitySelect.adapter = adapter

        binding.spinnerCitySelect.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?, position: Int, id: Long
                ) {
                    // write code to perform some action
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        binding.homeScreenLogOut.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeScreen_to_signIn)
        }
    }
}