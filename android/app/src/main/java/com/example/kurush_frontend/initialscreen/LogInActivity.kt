package com.example.kurush_frontend.initialscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.ActivityLogInBinding
import com.example.kurush_frontend.databinding.ActivityOnboardingBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment=logInFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.login_frame,fragment)
                .commit()


    }
}