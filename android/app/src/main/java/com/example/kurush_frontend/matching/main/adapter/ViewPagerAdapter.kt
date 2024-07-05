package com.example.kurush_frontend.matching.main.adapter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kurush_frontend.data.response.MatchingData
import com.example.kurush_frontend.data.response.MatchingDataList
import com.example.kurush_frontend.matching.main.MatchingCountryFragment
import com.example.kurush_frontend.matching.main.MatchingFreeFragment
import com.example.kurush_frontend.matching.main.MatchingHabitFragment
import com.example.kurush_frontend.matching.main.MatchingStudyFragment

class ViewPagerAdapter(fragment : Fragment, var matchDataList: MatchingDataList) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putSerializable("matchDataList", matchDataList)
        val matchingStudyFragment = MatchingStudyFragment()
        matchingStudyFragment.arguments = bundle
        val matchingCountryFragment = MatchingCountryFragment()
        matchingCountryFragment.arguments = bundle
        val matchingHabitFragment = MatchingHabitFragment()
        matchingHabitFragment.arguments = bundle
        val matchingFreeFragment = MatchingFreeFragment()
        matchingFreeFragment.arguments = bundle



        return when (position) {
            0-> matchingStudyFragment
            1-> matchingHabitFragment
            2-> matchingCountryFragment
            else-> matchingFreeFragment
        }
    }

}