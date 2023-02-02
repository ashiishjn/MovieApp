package com.example.movieapp.ui

import android.widget.Button
import androidx.core.content.ContextCompat.getColor
import com.example.movieapp.R
import com.example.movieapp.UserLoginActivity

class UserLoginView {

    var flag : Boolean = true
    fun onFocusListener(view: UserLoginActivity) {

        val toSignIn : Button = view.findViewById(R.id.ToSignIn)
        val toSignUp : Button = view.findViewById(R.id.ToSignUp)

        toSignIn.setOnClickListener {
            if(!flag){
                UserLoginActivity().SignIn()
                flag = true
            }
        }

        toSignUp.setOnClickListener {
            if(flag){
                UserLoginActivity().SignUp()
                flag = false
            }
        }
    }

    fun updateToSignIn(view: UserLoginActivity) {
        val toSignIn : Button = view.findViewById(R.id.ToSignIn)
        val SignUp : Button = view.findViewById(R.id.ToSignUp)

        toSignIn.setBackgroundResource(R.drawable.login_signup_button_bold)
        toSignIn.setTextColor(getColor(view, R.color.theme_background))

        SignUp.setBackgroundResource(R.drawable.login_signup_button_transparent)
        SignUp.setTextColor(getColor(view, R.color.extra_light_grey))
    }

    fun updateToSignUp(view: UserLoginActivity) {
        val SignIn : Button = view.findViewById(R.id.ToSignIn)
        val toSignUp : Button = view.findViewById(R.id.ToSignUp)

        SignIn.setBackgroundResource(R.drawable.login_signup_button_transparent)
        SignIn.setTextColor(getColor(view, R.color.extra_light_grey))

        toSignUp.setBackgroundResource(R.drawable.login_signup_button_bold)
        toSignUp.setTextColor(getColor(view, R.color.theme_background))
    }
}