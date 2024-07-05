package com.example.kurush_frontend.matching.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kurush_frontend.matching.main.MatchingCountryFragment
import com.example.kurush_frontend.matching.main.MatchingFreeFragment
import com.example.kurush_frontend.matching.main.MatchingHabitFragment
import com.example.kurush_frontend.matching.main.MatchingStudyFragment

class ViewPagerAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0-> MatchingStudyFragment()
            1-> MatchingHabitFragment()
            2-> MatchingCountryFragment()
            else-> MatchingFreeFragment()
        }
    }

}