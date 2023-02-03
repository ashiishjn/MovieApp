package com.example.movieapp.fragment

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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.ui.SignInView

class SignInActivityFragment : Fragment() {

    val signInView : SignInView = SignInView()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        signInView.workWithListener(view)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            Toast.makeText(view.context, "SignIn Successful", Toast.LENGTH_SHORT).show();
            listener.onSignInButtonSelected()
        }

        view.findViewById<TextView>(R.id.signInasAdmin).setOnClickListener {
            listener.onToSignInAsAdminSelected()
        }

        view.findViewById<Button>(R.id.SignInToSignUp).setOnClickListener {
            listener.onToSignUpButtonSelected()
        }
    }

    private lateinit var listener : SignInToSignUp

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SignInToSignUp) {
            listener =
                context as SignInToSignUp // = (YourActivity) context
        } else {
            throw ClassCastException(
                context.toString()
                        + " must implement SignInToSignUp.onSignUpButtonSelected"
            )
        }
    }

    interface SignInToSignUp {
        fun onToSignUpButtonSelected()
        fun onToSignInAsAdminSelected()
        fun onSignInButtonSelected()
    }

}