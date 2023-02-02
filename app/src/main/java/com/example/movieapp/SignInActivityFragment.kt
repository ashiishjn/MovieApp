package com.example.movieapp

import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignInActivityFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var flag : Boolean = true

        val username : EditText = view.findViewById(R.id.login_username)
        val password : EditText = view.findViewById(R.id.login_password)

        val showPassword : ImageButton = view.findViewById(R.id.login_showpassword)

        val logIn : Button = view.findViewById(R.id.loginButton)

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

        logIn.setOnClickListener { Toast.makeText(view.context, "SignIn Successful", Toast.LENGTH_SHORT).show(); }
    }

//    private lateinit var listener : ShowSignUp
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is com.example.movieapp.
//            SignInActivityFragment.ShowSignUp) {
//            listener =
//                context as ShowSignUp // = (YourActivity) context
//        } else {
//            throw ClassCastException(
//                context.toString()
//                        + " must implement SignInActivityFragment.onSignUpButtonSelected"
//            )
//        }
//    }
//
//    interface ShowSignUp {
//        fun onSignUpButtonSelected()
//    }

}