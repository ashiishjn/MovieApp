package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.fragment.SignInActivityFragment
import com.example.movieapp.fragment.SignUpActivityFragment
import com.example.movieapp.ui.UserLoginView

class MainActivity : AppCompatActivity(), SignUpActivityFragment.SignUpToSignIn, SignInActivityFragment.SignInToSignUp {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val userLoginView : UserLoginView = UserLoginView()

    override fun onStart() {
        super.onStart()
        userLoginView.ToSignIn(this)
    }

    override fun onToSignInButtonSelected() {
        userLoginView.ToSignIn(this)
    }

    override fun onSignUpButtonSelected() {
        userLoginView.UserSignUp(this)
    }

    override fun onToSignUpButtonSelected() {
        userLoginView.ToSignUp(this)
    }

    override fun onToSignInAsAdminSelected() {
        userLoginView.ToadminLogin(this)
    }

    override fun onSignInButtonSelected() {
        userLoginView.UserSignIn(this)
    }
}