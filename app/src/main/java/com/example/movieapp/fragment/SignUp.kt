package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.databinding.FragmentSignUpBinding
import com.example.movieapp.ui.SignUpView

class SignUp : Fragment() {

    private val signUpView : SignUpView = SignUpView()

    private  var _binding :FragmentSignUpBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSignUpBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        signUpView.workWithListener(view, binding)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}