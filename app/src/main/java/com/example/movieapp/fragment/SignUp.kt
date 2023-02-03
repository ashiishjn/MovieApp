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
import com.example.movieapp.ui.SignUpView

class SignUp : Fragment() {

    val signUpView : SignUpView = SignUpView()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        signUpView.workWithListener(view)

        view.findViewById<Button>(R.id.signUp_button).setOnClickListener {
            Toast.makeText(view.context, "SignUp Successful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_signUp_to_movieDescription)
        }

        view.findViewById<Button>(R.id.SignUpToSignIn).setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_signIn)
        }
    }
}