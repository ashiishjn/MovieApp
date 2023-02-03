package com.example.movieapp.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSignInBinding
import com.example.movieapp.databinding.FragmentSignUpBinding
import com.example.movieapp.ui.SignUpView

class SignUp : Fragment() {

    val signUpView : SignUpView = SignUpView()

    private  var _binding :FragmentSignUpBinding?=null
    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSignUpBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        binding.signUpButton.setOnClickListener {
            Toast.makeText(context, "SignUp Successful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_signUp_to_movieDescription)
        }

        binding.SignUpToSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_signIn)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        signUpView.workWithListener(view)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}