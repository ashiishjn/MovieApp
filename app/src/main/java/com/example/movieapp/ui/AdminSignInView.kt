package com.example.movieapp.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentAdminSignInBinding

class AdminSignInView {
    fun workWithListener(view : View, binding : FragmentAdminSignInBinding) {
        var flag : Boolean = true

        binding.adminShowpassword.setImageResource(R.drawable.va_baseline_visibility_off_24)
        binding.adminShowpassword.setOnClickListener(View.OnClickListener {
            if (flag) {
                binding.adminShowpassword.setImageResource(R.drawable.va_baseline_visibility_24)
                binding.adminPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                binding.adminShowpassword.setImageResource(R.drawable.va_baseline_visibility_off_24)
                binding.adminPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        binding.adminSignInButton.setOnClickListener {
            Toast.makeText(view.context,
            "SignIn Successful", Toast.LENGTH_SHORT).show();

            view.findNavController().navigate(R.id.action_adminSignIn_to_seatsSelection)
        }

    }
}