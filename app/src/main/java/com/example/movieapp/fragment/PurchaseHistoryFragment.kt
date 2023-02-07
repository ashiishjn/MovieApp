package com.example.movieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentPurchaseHistoryBinding

class PurchaseHistoryFragment : Fragment() {

    private  var _binding : FragmentPurchaseHistoryBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentPurchaseHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.theatreSelectionBackArrow.setOnClickListener {
            view.findNavController().navigate(R.id.action_purchaseHistoryFragment_to_homeScreen)
        }
    }

}