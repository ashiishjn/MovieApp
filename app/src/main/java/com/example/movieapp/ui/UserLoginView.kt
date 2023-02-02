package com.example.movieapp.ui

import android.widget.Button
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentTransaction
import com.example.movieapp.R
import com.example.movieapp.UserLoginActivity

class UserLoginView {



    fun SignIn(userLoginActivity: UserLoginActivity){
        val signInActivityFragment : SignInActivityFragment = SignInActivityFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signInActivityFragment)
        fragmentTransaction.commit()
    }

    fun SignUp(userLoginActivity: UserLoginActivity) {
        val signUpActivityFragment : SignUpActivityFragment = SignUpActivityFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signUpActivityFragment)
        fragmentTransaction.commit()
    }

    fun adminLogin(userLoginActivity: UserLoginActivity) {
        val adminLoginFragment : AdminLoginFragment = AdminLoginFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, adminLoginFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}