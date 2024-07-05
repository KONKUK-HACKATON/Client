package com.example.kurush_frontend

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.databinding.ActivityMainBinding
import com.example.kurush_frontend.initialscreen.departmentFragment
import com.example.kurush_frontend.initialscreen.eatingFragment
import com.example.kurush_frontend.initialscreen.studennumFragment
import com.example.kurush_frontend.matching.add.MatchingAddFragment
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, MatchingMainFragment()).commit()

        initBottomNavigation()

//        supportFragmentManager.beginTransaction().replace(R.id.main_frm, )
//            .commitAllowingStateLoss()

    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.selectedItemId = R.id.fragment_addUser

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.fragment_calendar -> {
                    //TODO calender fragment 생성
                }
                R.id.fragment_addUser -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MatchingMainFragment()).commit()
                }
                R.id.fragment_home -> {
                    //TODO home fragment 생성
                }
                R.id.fragment_chat -> {
                    //TODO chat fragment 생성.
                }
            }
            true
        }
    }
}