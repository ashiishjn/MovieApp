package com.example.movieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.FragmentConfirmationScreenBinding
import com.example.movieapp.ui.ConfirmationScreenView


class ConfirmationScreenFragment : Fragment() {

    val confirmationScreenView : ConfirmationScreenView = ConfirmationScreenView()

    private  var _binding : FragmentConfirmationScreenBinding?=null
    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentConfirmationScreenBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        confirmationScreenView.workWithListener(view, binding)

    }
}