package com.example.movieapp.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.movieapp.R

class AdminSignInView {
    fun workWithListener(view : View) {
        var flag : Boolean = true

        val username : EditText = view.findViewById(R.id.admin_username)
        val password : EditText = view.findViewById(R.id.admin_password)

        val showPassword : ImageButton = view.findViewById(R.id.admin_showpassword)

        val logIn : Button = view.findViewById(R.id.admin_signInButton)

        showPassword.setImageResource(R.drawable.va_baseline_visibility_off_24)

        showPassword.setOnClickListener(View.OnClickListener {
            if (flag) {
                showPassword.setImageResource(R.drawable.va_baseline_visibility_24)
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                showPassword.setImageResource(R.drawable.va_baseline_visibility_off_24)
                password.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        logIn.setOnClickListener { Toast.makeText(view.context, "SignIn Successful", Toast.LENGTH_SHORT).show(); }
    }
}