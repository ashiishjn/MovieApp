package com.example.movieapp.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import com.example.movieapp.AdminLoginActivity
import com.example.movieapp.R

class AdminLoginView {

    fun onFocusListener(adminLoginActivity: AdminLoginActivity) {

        var flag : Boolean = true

        val username : EditText = adminLoginActivity.findViewById(R.id.admin_username)
        val password : EditText = adminLoginActivity.findViewById(R.id.admin_password)

        val showPassword : ImageButton = adminLoginActivity.findViewById(R.id.admin_showpassword)

        val logIn : Button = adminLoginActivity.findViewById(R.id.admin_signInButton)

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

        logIn.setOnClickListener { Toast.makeText(adminLoginActivity, "SignIn Successful", Toast.LENGTH_SHORT).show(); }

    }
}