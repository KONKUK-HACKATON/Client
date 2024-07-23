package com.example.kurush_frontend.help

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.ActivityHelpBinding
import com.example.kurush_frontend.initialscreen.logInFragment
import com.example.myapplication.SchoolMapFragment

class HelpActivity : AppCompatActivity() {
    lateinit var binding:ActivityHelpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment= SchoolMapFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.help_frame,fragment)
            .commit()
    }
}