package com.itis.firstdaysummerpructise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tvPass: TextView? = null
    private var tvEmail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email = intent?.extras?.getString("EXTRA_EMAIL")
        var password = intent?.extras?.getString("EXTRA_PASS")

        tvPass = findViewById(R.id.tv_password)
        tvEmail = findViewById(R.id.tv_email)

        if(email != null)
        {
            tvEmail?.text = email
        }
        if(password != null)
        {
            tvPass?.text = password
        }
    }
}