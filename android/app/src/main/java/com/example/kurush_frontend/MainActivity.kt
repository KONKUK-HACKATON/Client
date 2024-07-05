package com.example.kurush_frontend

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.databinding.ActivityMainBinding
import com.example.kurush_frontend.initialscreen.departmentFragment
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main, departmentFragment())
//            .commit()

//        supportFragmentManager.beginTransaction().replace(R.id.main_frm, )
//            .commitAllowingStateLoss()

    }
}