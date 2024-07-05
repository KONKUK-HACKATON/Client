package com.example.kurush_frontend.matching.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.databinding.FragmentMatchingHabitBinding

class MatchingHabitFragment : Fragment() {
    lateinit var binding: FragmentMatchingHabitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("habit", "habit")
        binding = FragmentMatchingHabitBinding.inflate(inflater, container, false)

        return binding.root
    }

}