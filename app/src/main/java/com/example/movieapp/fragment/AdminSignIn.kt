package com.example.movieapp.fragment

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentAdminSignInBinding
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.ui.AdminSignInView

class AdminSignIn : Fragment() {

    private  var _binding : FragmentAdminSignInBinding?=null
    private  val binding get() = _binding!!

    val adminSignInView : AdminSignInView = AdminSignInView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAdminSignInBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adminSignInView.workWithListener(view, binding)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}