package com.itis.firstdaysummerpructise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import java.security.AccessController

class SingleActivity : AppCompatActivity() {
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        controller = (supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment).navController
    }

    override fun onSupportNavigateUp(): Boolean = controller.navigateUp()
}