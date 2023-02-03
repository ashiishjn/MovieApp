package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.fragment.SignInActivityFragment
import com.example.movieapp.fragment.SignUpActivityFragment
import com.example.movieapp.ui.MainActivityView

class MainActivity : AppCompatActivity(), SignUpActivityFragment.SignUpToSignIn, SignInActivityFragment.SignInToSignUp {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val mainActivityView : MainActivityView = MainActivityView()

    override fun onStart() {
        super.onStart()
        mainActivityView.ToSignIn(this)
    }

    override fun onToSignInButtonSelected() {
        mainActivityView.ToSignIn(this)
    }

    override fun onSignUpButtonSelected() {
        mainActivityView.UserSignUp(this)
    }

    override fun onToSignUpButtonSelected() {
        mainActivityView.ToSignUp(this)
    }

    override fun onToSignInAsAdminSelected() {
        mainActivityView.ToadminLogin(this)
    }

    override fun onSignInButtonSelected() {
        mainActivityView.UserSignIn(this)
    }
}