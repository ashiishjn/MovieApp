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
import com.example.movieapp.ui.SignInView

class SignIn : Fragment() {

    val signInView : SignInView = SignInView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        signInView.workWithListener(view)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            Toast.makeText(view.context, "SignIn Successful", Toast.LENGTH_SHORT).show();
            findNavController().navigate(R.id.action_signIn_to_homeScreen)
        }

        view.findViewById<TextView>(R.id.signInasAdmin).setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_adminSignIn)
        }

        view.findViewById<Button>(R.id.SignInToSignUp).setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
    }

}