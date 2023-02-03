package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.ui.SignInView

class SignIn : Fragment() {

    val signInView : SignInView = SignInView()

    private  var _binding :FragmentSignInBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSignInBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            Toast.makeText(context, "SignIn Successful", Toast.LENGTH_SHORT).show();
            findNavController().navigate(R.id.action_signIn_to_homeScreen)
        }

        binding.signInasAdmin.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_adminSignIn)
        }

        binding.SignInToSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signInView.workWithListener(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}