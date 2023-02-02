package com.example.movieapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.movieapp.R


class SignUpActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name : EditText = view.findViewById(R.id.signUp_name)
        val email : EditText = view.findViewById(R.id.signUp_emailId)
        val mobileNo : EditText = view.findViewById(R.id.signUp_mobileNo)
        val password : EditText = view.findViewById(R.id.signUp_password1)
        val confirmPassword : EditText = view.findViewById(R.id.signUp_password2)
        val signUp : Button = view.findViewById(R.id.signUp_button)

        val showPassword: ImageButton = view.findViewById(R.id.signUp_showPassword1)
        val confirmShowPassword: ImageButton = view.findViewById(R.id.signUp_showPassword2)

        mobileNo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length != 10) {
                    mobileNo.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.va_baseline_smartphone_24,
                        0,
                        R.drawable.va_baseline_error_outline_24,
                        0
                    )
                } else {
                    mobileNo.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.va_baseline_smartphone_24,
                        0,
                        0,
                        0
                    )
                }
            }
        })

        var flag = true
        var confirmFlag = true

        showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
        showPassword.setOnClickListener(View.OnClickListener {
            if (flag) {
                showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_24)
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                flag = false
            } else {
                showPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
                password.setTransformationMethod(PasswordTransformationMethod.getInstance())
                flag = true
            }
        })

        confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
        confirmShowPassword.setOnClickListener(View.OnClickListener {
            if (confirmFlag) {
                confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_24)
                confirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                confirmFlag = false
            } else {
                confirmShowPassword.setBackgroundResource(R.drawable.va_baseline_visibility_off_24)
                confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
                confirmFlag = true
            }
        })

        signUp.setOnClickListener {
            Toast.makeText(view.context, "SignUp Successful", Toast.LENGTH_SHORT).show()
        }
    }
}