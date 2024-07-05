package com.example.kurush_frontend

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.databinding.ActivityMainBinding
import com.example.kurush_frontend.help.HelpMainFragment
import com.example.kurush_frontend.initialscreen.departmentFragment
import com.example.kurush_frontend.initialscreen.eatingFragment
import com.example.kurush_frontend.initialscreen.studennumFragment
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.example.kurush_frontend.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var colleage: String? = null
    private var major: String? = null
    private var memberId: Int? = null
    private var studentNumber: Int? = null
    private var nation: String? = null
    private var language: String? = null
    private var singularity: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, MatchingMainFragment()).commit()

//        supportFragmentManager.beginTransaction().replace(R.id.main_frm, )
//            .commitAllowingStateLoss()
        initBottomNavigation()

    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.fragment_addUser -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MatchingMainFragment())
                        .commit()
                    true
                }
                R.id.fragment_calendar -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HelpMainFragment())
                        .commit()
                    true
                }
                R.id.fragment_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MyPageFragment())
                        .commit()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}