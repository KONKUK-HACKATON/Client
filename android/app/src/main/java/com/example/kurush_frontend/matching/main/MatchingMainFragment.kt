package com.example.kurush_frontend.matching.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.databinding.FragmentMatchingMainBinding
import com.example.kurush_frontend.matching.main.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MatchingMainFragment : Fragment() {
    lateinit var binding: FragmentMatchingMainBinding
    private val tabList = arrayListOf("스터디", "생활습관", "국가별", "자유")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingMainBinding.inflate(inflater, container, false)

        initTabLayout()




        return binding.root
    }

    private fun initTabLayout() {

        binding.vpMatchingMain.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tlMatchingMain, binding.vpMatchingMain) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }


}