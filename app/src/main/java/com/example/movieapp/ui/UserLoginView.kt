package com.example.movieapp.ui

import android.widget.Button
import androidx.core.content.ContextCompat.getColor
import com.example.movieapp.R
import com.example.movieapp.UserLoginActivity

class UserLoginView {

    var flag : Boolean = true
    fun onFocusListener(userLoginActivity: UserLoginActivity) {

        val toSignIn : Button = userLoginActivity.findViewById(R.id.ToSignIn)
        val toSignUp : Button = userLoginActivity.findViewById(R.id.ToSignUp)

        userLoginActivity.SignIn()
        updateToSignIn(userLoginActivity)

        toSignIn.setOnClickListener {
            if(!flag){
                userLoginActivity.SignIn()
                updateToSignIn(userLoginActivity)
                flag = true
            }
        }

        toSignUp.setOnClickListener {
            if(flag){
                userLoginActivity.SignUp()
                updateToSignUp(userLoginActivity)
                flag = false
            }
        }
    }

    fun updateToSignIn(userLoginActivity: UserLoginActivity) {
        val toSignIn : Button = userLoginActivity.findViewById(R.id.ToSignIn)
        val SignUp : Button = userLoginActivity.findViewById(R.id.ToSignUp)

        toSignIn.setBackgroundResource(R.drawable.login_signup_button_bold)
        toSignIn.setTextColor(getColor(userLoginActivity, R.color.theme_background))

        SignUp.setBackgroundResource(R.drawable.login_signup_button_transparent)
        SignUp.setTextColor(getColor(userLoginActivity, R.color.extra_light_grey))
    }

    fun updateToSignUp(userLoginActivity: UserLoginActivity) {
        val SignIn : Button = userLoginActivity.findViewById(R.id.ToSignIn)
        val toSignUp : Button = userLoginActivity.findViewById(R.id.ToSignUp)

        SignIn.setBackgroundResource(R.drawable.login_signup_button_transparent)
        SignIn.setTextColor(getColor(userLoginActivity, R.color.extra_light_grey))

        toSignUp.setBackgroundResource(R.drawable.login_signup_button_bold)
        toSignUp.setTextColor(getColor(userLoginActivity, R.color.theme_background))
    }
}