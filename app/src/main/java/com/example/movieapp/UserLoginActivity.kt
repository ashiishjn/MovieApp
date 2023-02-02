package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class UserLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
    }

    override fun onStart() {
        super.onStart()
        val userLoginView : UserLoginView = UserLoginView()
//        userLoginView.onFocusListener(this)

        SignIn()
        userLoginView.updateToSignIn(this)
        var flag = true
        val toSignIn : Button = findViewById(R.id.ToSignIn)
        val toSignUp : Button = findViewById(R.id.ToSignUp)

        toSignIn.setOnClickListener {
            if(!flag){
                SignIn()
                userLoginView.updateToSignIn(this)
                flag = true
            }
        }

        toSignUp.setOnClickListener {
            if(flag){
                SignUp()
                userLoginView.updateToSignUp(this)
                flag = false
            }
        }
    }

    fun SignIn(){
        val signInActivityFragment : SignInActivityFragment = SignInActivityFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signInActivityFragment)
        fragmentTransaction.commit()
    }

    fun SignUp() {
        val signUpActivityFragment : SignUpActivityFragment = SignUpActivityFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.login_signup_frame_layout, signUpActivityFragment)
        fragmentTransaction.commit()
    }
}