package com.example.movieapp.ui

import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.movieapp.R

class SignUpView {
    fun workWithListener(view : View) {
        val name : EditText = view.findViewById(R.id.signUp_name)
        val email : EditText = view.findViewById(R.id.signUp_emailId)
        val mobileNo : EditText = view.findViewById(R.id.signUp_mobileNo)
        val password : EditText = view.findViewById(R.id.signUp_password1)
        val confirmPassword : EditText = view.findViewById(R.id.signUp_password2)

        val showPassword: ImageButton = view.findViewById(R.id.signUp_showPassword1)
        val confirmShowPassword: ImageButton = view.findViewById(R.id.signUp_showPassword2)

        mobileNo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length != 10) {
                    mobileNo.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.va_baseline_smartphone_24,
                        0,
                        R.drawable.va_baseline_error_outline_24,
                        0
                    )
                } else {
                    mobileNo.setCompoundDrawablesWithIntrinsicBounds(
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

        showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
        showPassword.setOnClickListener(View.OnClickListener {
            if (flag) {
                showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_24)
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
                password.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
        confirmShowPassword.setOnClickListener(View.OnClickListener {
            if (confirmFlag) {
                confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_24)
                confirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                confirmFlag = false
            } else {
                confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
                confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
                confirmFlag = true
            }
        })
    }
}