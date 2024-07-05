package com.example.kurush_frontend.initialscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.kurush_frontend.MainActivity
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentLogInBinding

class logInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)

        // Load saved credentials if available
        val (savedUsername, savedPassword) = readCredentials()
        binding.etId.setText(savedUsername)
        binding.etPw.setText(savedPassword)

        // 초기 설정 완료 여부 확인
        val sharedPreferences = requireActivity().getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val isInitialSetupCompleted = sharedPreferences.getBoolean("is_initial_setup_completed", false)
        Log.d("flag", isInitialSetupCompleted.toString())
        binding.ivLoginBtn.setOnClickListener {
            val username = binding.etId.text.toString()
            val password = binding.etPw.text.toString()

            if (isInitialSetupCompleted) {
                // Save credentials if login is successful and initial setup is completed
                saveCredentials(username, password)

                // 초기 설정 완료되었으면 매칭 메인 화면으로 이동
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            } else {
                // 초기 설정 화면으로 이동
                val fragment = departmentFragment()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.login_frame, fragment)
                    .commit()
            }
        }

        return binding.root
    }

    // 초기 설정 완료 여부를 저장하는 함수
    fun setInitialSetupCompleted(isCompleted: Boolean) {
        val sharedPreferences = requireContext().getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean("is_initial_setup_completed", isCompleted)
            apply()
        }
    }

    // 초기 설정 완료 여부를 초기화하는 함수
    fun resetInitialSetup() {
        setInitialSetupCompleted(false)
    }

    // 데이터 저장
    fun saveCredentials(username: String, password: String) {
        val sharedPreferences = requireContext().getSharedPreferences("app_credentials", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("username", username)
            putString("password", password)
            commit()
        }
    }

    // 데이터 읽기
    fun readCredentials(): Pair<String?, String?> {
        val sharedPreferences = requireContext().getSharedPreferences("app_credentials", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return Pair(username, password)
    }
}