package com.example.kurush_frontend.initialscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kurush_frontend.MainActivity
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    lateinit var binding:ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 일정 시간 지연 이후 실행하기 위한 코드
        Handler(Looper.getMainLooper()).postDelayed({

            val intent=Intent(this,LogInActivity::class.java)
            startActivity(intent)

//            val fragment=logInFragment()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container_view,fragment)
//                .commit()

            finish()


        }, 2000) // 시간 2초 이후 실행
    }
}