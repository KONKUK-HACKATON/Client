package com.example.kurush_frontend.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentHelpMainBinding
import com.example.kurush_frontend.initialscreen.LogInActivity
import com.example.kurush_frontend.initialscreen.departmentFragment
import com.example.kurush_frontend.initialscreen.logInFragment
import com.example.kurush_frontend.matching.add.MatchingAddFragment

class HelpMainFragment : Fragment() {
    lateinit var binding:FragmentHelpMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHelpMainBinding.inflate(inflater,container,false)
        binding.tvKonkukSystem.setOnClickListener {
            val url = "https://www.konkuk.ac.kr/konkuk/index.do"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }
        binding.tvKonkukSite.setOnClickListener {
            val url = "https://kuis.konkuk.ac.kr/index.do"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        binding.ivSchoolMap.setOnClickListener {
            val intent=Intent(requireContext(), HelpActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}