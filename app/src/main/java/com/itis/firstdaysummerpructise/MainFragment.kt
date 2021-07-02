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
        }

}