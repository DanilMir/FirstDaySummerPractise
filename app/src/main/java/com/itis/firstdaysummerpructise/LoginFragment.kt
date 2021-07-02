package com.itis.firstdaysummerpructise

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class LoginFragment: Fragment(R.layout.fragment_login) {
    private val users = hashMapOf<String, String>("test" to "12345")

    private var etEmail: EditText? = null
    private var tiEmail: TextInputLayout? = null
    private var etPassword: EditText? = null
    private var tiPassword: TextInputLayout? = null
    private var btnLogin: Button? = null
    private var btnSettings: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findView(view)
        initListeners()
    }

    private fun initListeners()
    {
        btnLogin?.setOnClickListener{
            val email = etEmail?.text?.toString() ?: ""
            val password = etPassword?.text?.toString() ?: ""

            if(email.isEmpty())
            {
                tiEmail?.error = getString(R.string.empty_field)
                return@setOnClickListener
            }

            if(password.isEmpty())
            {
                tiPassword?.error = getString(R.string.empty_field)
                return@setOnClickListener
            }


            var passFromBase: String? = users[email]
            var message = when{
                passFromBase == null -> "User not found"
                password == passFromBase -> {
                    /*val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    intent.putExtra("EXTRA_PASS", password)
                    startActivity(intent)
                    */"Nice"
                }
                else -> "Correct password: $passFromBase"
            }
            etEmail?.hideKeyboard(requireContext())
            showMessage(message)
        }

        etEmail?.addTextChangedListener {
            tiEmail?.isErrorEnabled = false
            tiEmail?.error = null
        }

        etPassword?.addTextChangedListener {
            tiPassword?.isErrorEnabled = false
            tiPassword?.error = null
        }
    }

    private fun showMessage(message: String)
    {
        activity?.findViewById<View>(android.R.id.content)?.also {
            Snackbar.make(
                it,
                message,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun findView(view: View)
    {
        etEmail = view.findViewById(R.id.et_email)
        tiEmail = view.findViewById(R.id.ti_email)
        etPassword = view.findViewById(R.id.et_password)
        tiPassword = view.findViewById(R.id.ti_password)
        btnLogin = view.findViewById(R.id.btn_login)
        btnSettings = view.findViewById(R.id.btn_settings)
    }
}