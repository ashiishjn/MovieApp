package com.example.movieapp.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentAdminSignInBinding
import com.example.movieapp.databinding.FragmentSignInBinding

class SignInView {

    val email : String = "ashish@gmail.com"
    val password : String = "12345678"

    fun workWithListener(view : View, binding: FragmentSignInBinding) {
        var flag : Boolean = true

        binding.loginShowpassword.setImageResource(R.drawable.va_baseline_visibility_off_24)

        binding.loginShowpassword.setOnClickListener(View.OnClickListener {
            if (flag) {
                binding.loginShowpassword.setImageResource(R.drawable.va_baseline_visibility_24)
                binding.loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                binding.loginShowpassword.setImageResource(R.drawable.va_baseline_visibility_off_24)
                binding.loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        binding.loginButton.setOnClickListener {

            if(binding.loginUsername.text.toString() == email
                && binding.loginPassword.text.toString() == password
            ) {
                Toast.makeText(view.context, "SignIn Successful", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_signIn_to_homeScreen)
            }
            else {
                Toast.makeText(view.context, "Enter correct email id and password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signInasAdmin.setOnClickListener {
            view.findNavController().navigate(R.id.action_signIn_to_adminSignIn)
        }

        binding.SignInToSignUp.setOnClickListener {
            view.findNavController().navigate(R.id.action_signIn_to_signUp)
        }
    }

}