package com.example.kurush_frontend.initialscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.kurush_frontend.MainActivity
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentLogInBinding


class logInFragment : Fragment() {
    lateinit var binding:FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLogInBinding.inflate(inflater,container,false)

        // 초기 설정 완료 여부 확인
        val sharedPreferences = requireActivity().getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val isInitialSetupCompleted = sharedPreferences.getBoolean("is_initial_setup_completed", false)

        binding.ivLoginBtn.setOnClickListener {
            val fragment = departmentFragment()

            if (isInitialSetupCompleted) {
                // 초기 설정 완료되었으면 매칭 메인 화면으로 이동
                val intent = Intent(requireContext(),MainActivity::class.java)
                startActivity(intent)
            } else {
                // 초기 설정 화면으로 이동
                parentFragmentManager.beginTransaction()
                    .replace(R.id.login_frame,fragment)
                    .commit()
            }
        }

        return binding.root
    }

}