package com.example.movieapp.ui

import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSignUpBinding

class SignUpView {
    fun workWithListener(view : View, binding : FragmentSignUpBinding) {

        binding.signUpMobileNo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length != 10) {
                    binding.signUpMobileNo.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.va_baseline_smartphone_24,
                        0,
                        R.drawable.va_baseline_error_outline_24,
                        0
                    )
                } else {
                    binding.signUpMobileNo.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.va_baseline_smartphone_24,
                        0,
                        0,
                        0
                    )
                }
            }
        })

        var flag = true
        var confirmFlag = true

        binding.signUpShowPassword1.setImageResource(R.drawable.va_baseline_visibility_off_24)
        binding.signUpShowPassword1.setOnClickListener(View.OnClickListener {
            if (flag) {
                binding.signUpShowPassword1.setImageResource(R.drawable.va_baseline_visibility_24)
                binding.signUpPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                binding.signUpShowPassword1.setImageResource(R.drawable.va_baseline_visibility_off_24)
                binding.signUpPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        binding.signUpShowPassword2.setImageResource(R.drawable.va_baseline_visibility_off_24)
        binding.signUpShowPassword2.setOnClickListener(View.OnClickListener {
            if (confirmFlag) {
                binding.signUpShowPassword2.setImageResource(R.drawable.va_baseline_visibility_24)
                binding.signUpPassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                confirmFlag = false
            } else {
                binding.signUpShowPassword2.setImageResource(R.drawable.va_baseline_visibility_off_24)
                binding.signUpPassword2.setTransformationMethod(PasswordTransformationMethod.getInstance())
                confirmFlag = true
            }
        })

        binding.signUpButton.setOnClickListener {
//            if(binding.signUpName.text.toString().isEmpty())
//                binding.signUpName.error = "This Field cannot be empty"
//
//            else if(!Patterns.EMAIL_ADDRESS.matcher(binding.signUpEmailId.text.toString()).matches())
//                binding.signUpEmailId.error = "Invalid Email"
//
//            else if(binding.signUpMobileNo.text.toString().length != 10)
//                binding.signUpMobileNo.error = "Phone Number Should be of 10 digits"
//
//            else if(binding.signUpPassword1.text.toString().length < 8)
//                binding.signUpPassword1.error = "Password should be minimum of 8 characters"
//
//            else if(binding.signUpPassword2.text.toString().length < 8)
//                binding.signUpPassword2.error = "Password should be minimum of 8 characters"
//
//            else if(binding.signUpPassword1.text.toString() != binding.signUpPassword2.text.toString()){
//                binding.signUpPassword1.error = "Passwords does not match"
//                binding.signUpPassword2.error = "Passwords does not match"
//            }
//            else {
                Toast.makeText(view.context, "SignUp Successful", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_signUp_to_homeScreen)
//            }

        }

        binding.SignUpToSignIn.setOnClickListener {
            view.findNavController().navigate(R.id.action_signUp_to_signIn)
        }
    }
}