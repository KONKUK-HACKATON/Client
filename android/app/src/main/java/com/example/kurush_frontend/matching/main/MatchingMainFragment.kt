package com.example.kurush_frontend.matching.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.response.MatchingDataList
import com.example.kurush_frontend.data.response.MatchingDataResponse
import com.example.kurush_frontend.databinding.FragmentMatchingMainBinding
import com.example.kurush_frontend.matching.main.adapter.ViewPagerAdapter
import com.example.kurush_frontend.matching.write.WriteIssueFragment
import com.example.kurush_frontend.matching.write.WriteMatchingFragment
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchingMainFragment : Fragment() {
    lateinit var binding: FragmentMatchingMainBinding
    private val tabList = arrayListOf("스터디", "생활습관", "국가별", "자유")
    lateinit var searchData :String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingMainBinding.inflate(inflater, container, false)
        searchData = binding.etMatchingMain.text.toString()
        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)
        var matchDataList : MatchingDataList

        service.getMatchingList().enqueue(object : Callback<MatchingDataResponse>{
            override fun onResponse(
                call: Call<MatchingDataResponse>,
                response: Response<MatchingDataResponse>
            ) {
                Log.d("res",response.body().toString())

                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        Log.d("user", result.toString())
                        matchDataList = MatchingDataList(result.data)
                        Log.d("da", matchDataList.toString())
                        initTabLayout(matchDataList, searchData)
                        initSearch(matchDataList)
                    }
                }
            }

            override fun onFailure(call: Call<MatchingDataResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })





        binding.flMatchingMainWriteBtn.setOnClickListener{
            binding.vMatchinMainGray.alpha = 0.7F
            binding.ivMatchingMainWrite.visibility = View.GONE
            binding.ivMatchingMainCancle.visibility = View.VISIBLE
            binding.ivMatchingMainBtnMatching.visibility = View.VISIBLE
            binding.ivMatchingMainBtnIssue.visibility = View.VISIBLE

            binding.ivMatchingMainCancle.setOnClickListener {
                binding.vMatchinMainGray.alpha = 0F
                binding.ivMatchingMainWrite.visibility = View.VISIBLE
                binding.ivMatchingMainCancle.visibility = View.GONE
                binding.ivMatchingMainBtnMatching.visibility = View.GONE
                binding.ivMatchingMainBtnIssue.visibility = View.GONE
            }

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

    private fun initSearch(matchDataList: MatchingDataList) {
        binding.ivMatchingMainSearch.setOnClickListener {

            searchData = binding.etMatchingMain.text.toString()
            binding.vpMatchingMain.adapter = ViewPagerAdapter(this, matchDataList, searchData)
        }
    }

    private fun initTabLayout(matchDataList: MatchingDataList, searchData: String) {

        binding.vpMatchingMain.adapter = ViewPagerAdapter(this, matchDataList, searchData)
        TabLayoutMediator(binding.tlMatchingMain, binding.vpMatchingMain) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }


}