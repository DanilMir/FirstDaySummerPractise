package com.itis.firstdaysummerpructise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MainFragment : Fragment(R.layout.fragment_main) {
    private var tvPass: TextView? = null
    private var tvEmail: TextView? = null
    private var btnSettings: Button? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            tvEmail = view.findViewById(R.id.tv_email)
            tvPass = view.findViewById(R.id.tv_password)

            val email: String? = arguments?.getString(ARG_EMAIL)
            val pass: String? = arguments?.getString(ARG_PASS)

            if (email != null) {
                tvEmail?.text = "Email: $email"
            }
            if (pass != null) {
                tvPass?.text = "Password: $pass"
            }
        }

    companion object {

        private const val ARG_EMAIL = "ARG_EMAIL"
        private const val ARG_PASS = "ARG_PASS"

        fun createBundle(email: String, pass: String): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
            putString(ARG_PASS, pass)
        }
    }

}