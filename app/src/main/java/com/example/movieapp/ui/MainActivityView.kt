package com.example.movieapp.ui

import android.widget.ScrollView
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentTransaction
import com.example.movieapp.R
import com.example.movieapp.MainActivity
import com.example.movieapp.fragment.*

class MainActivityView {

    fun ToSignIn(mainActivity: MainActivity){
        val signInActivityFragment : SignInActivityFragment = SignInActivityFragment()
        val fragmentTransaction: FragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signInActivityFragment)
        fragmentTransaction.commit()
        setBackgroundThemeColor(mainActivity)
    }

    fun ToSignUp(mainActivity: MainActivity) {
        val signUpActivityFragment : SignUpActivityFragment = SignUpActivityFragment()
        val fragmentTransaction: FragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signUpActivityFragment)
        fragmentTransaction.commit()
        setBackgroundThemeColor(mainActivity)
    }

    fun ToadminLogin(mainActivity: MainActivity) {
        val adminLoginFragment : AdminLoginFragment = AdminLoginFragment()
        val fragmentTransaction: FragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, adminLoginFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        setBackgroundThemeColor(mainActivity)
    }

    fun UserSignIn(mainActivity: MainActivity) {
        val homeScreenActivityFragment : HomeScreenActivityFragment = HomeScreenActivityFragment()
        val fragmentTransaction: FragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, homeScreenActivityFragment)
        fragmentTransaction.commit()
        setBackgroundWhite(mainActivity)
    }

    fun UserSignUp(mainActivity: MainActivity) {
        val movieDescriptionFragment : MovieDescriptionFragment = MovieDescriptionFragment()
        val fragmentTransaction: FragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, movieDescriptionFragment)
        fragmentTransaction.commit()
        setBackgroundWhite(mainActivity)
    }

    fun setBackgroundWhite(mainActivity: MainActivity) {
        val scroll_view_main_activity : ScrollView = mainActivity.findViewById(R.id.scroll_view_main_activity)
        scroll_view_main_activity.setBackgroundColor(getColor(mainActivity, R.color.white))
    }

    fun setBackgroundThemeColor(mainActivity: MainActivity) {
        val scroll_view_main_activity : ScrollView = mainActivity.findViewById(R.id.scroll_view_main_activity)
        scroll_view_main_activity.setBackgroundColor(getColor(mainActivity, R.color.theme_background))
    }
}