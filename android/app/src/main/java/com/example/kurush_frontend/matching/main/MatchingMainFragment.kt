package com.example.kurush_frontend.matching.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.Visibility
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentMatchingMainBinding
import com.example.kurush_frontend.matching.main.adapter.ViewPagerAdapter
import com.example.kurush_frontend.matching.write.WriteIssueFragment
import com.example.kurush_frontend.matching.write.WriteMatchingFragment
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

        binding.flMatchingMainWriteBtn.setOnClickListener{
            binding.vMatchinMainGray.alpha = 0.7F
            binding.ivMatchingMainWrite.visibility = View.GONE
            binding.ivMatchingMainCancle.visibility = View.VISIBLE
            binding.ivMatchingMainBtnMatching.visibility = View.VISIBLE
            binding.ivMatchingMainBtnIssue.visibility = View.VISIBLE

            // 매칭 게시글 작성
            binding.ivMatchingMainBtnMatching.setOnClickListener {
                binding.ivMatchingMainBtnMatching.visibility = View.GONE
                binding.ivMatchingMainBtnMatchingSelected.visibility = View.VISIBLE

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, WriteMatchingFragment())
                    .commit()
            }

            // 정보 게시글 작성
            binding.ivMatchingMainBtnIssue.setOnClickListener {
                binding.ivMatchingMainBtnIssue.visibility = View.GONE
                binding.ivMatchingMainBtnIssueSelecteed.visibility = View.VISIBLE

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, WriteIssueFragment())
                    .commit()
            }


        }


        return binding.root
    }

    private fun initTabLayout() {

        binding.vpMatchingMain.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tlMatchingMain, binding.vpMatchingMain) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }


}