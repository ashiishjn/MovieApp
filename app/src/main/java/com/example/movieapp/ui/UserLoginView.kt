package com.example.movieapp.ui

import android.widget.Button
import android.widget.ScrollView
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
        setBackgroundThemeColor(userLoginActivity)
    }

    fun SignUp(userLoginActivity: UserLoginActivity) {
        val signUpActivityFragment : SignUpActivityFragment = SignUpActivityFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signUpActivityFragment)
        fragmentTransaction.commit()
        setBackgroundThemeColor(userLoginActivity)
    }

    fun adminLogin(userLoginActivity: UserLoginActivity) {
        val adminLoginFragment : AdminLoginFragment = AdminLoginFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, adminLoginFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        setBackgroundThemeColor(userLoginActivity)
    }

    fun HomeScreenActivity(userLoginActivity: UserLoginActivity) {
        val homeScreenActivityFragment : HomeScreenActivityFragment = HomeScreenActivityFragment()
        val fragmentTransaction: FragmentTransaction = userLoginActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, homeScreenActivityFragment)
        fragmentTransaction.commit()
        setBackgroundWhite(userLoginActivity)
    }

    fun setBackgroundWhite(userLoginActivity: UserLoginActivity) {
        val scroll_view_main_activity : ScrollView = userLoginActivity.findViewById(R.id.scroll_view_main_activity)
        scroll_view_main_activity.setBackgroundColor(getColor(userLoginActivity, R.color.white))
    }

    fun setBackgroundThemeColor(userLoginActivity: UserLoginActivity) {
        val scroll_view_main_activity : ScrollView = userLoginActivity.findViewById(R.id.scroll_view_main_activity)
        scroll_view_main_activity.setBackgroundColor(getColor(userLoginActivity, R.color.theme_background))
    }
}