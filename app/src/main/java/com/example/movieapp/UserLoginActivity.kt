package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.movieapp.ui.SignInActivityFragment
import com.example.movieapp.ui.SignUpActivityFragment
import com.example.movieapp.ui.UserLoginView

class UserLoginActivity : AppCompatActivity(), SignUpActivityFragment.SignUpToSignIn, SignInActivityFragment.SignInToSignUp {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
    }

    val userLoginView : UserLoginView = UserLoginView()

    override fun onStart() {
        super.onStart()
        userLoginView.SignIn(this)
    }

    override fun onToSignInButtonSelected() {
        userLoginView.SignIn(this)
    }

    override fun onToSignUpButtonSelected() {
        userLoginView.SignUp(this)
    }

    override fun onToSignInAsAdminSelected() {
        userLoginView.adminLogin(this)
    }

    override fun onSignInButtonSelected() {
        userLoginView.HomeScreenActivity(this)
    }
}