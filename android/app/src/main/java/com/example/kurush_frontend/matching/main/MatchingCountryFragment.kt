package com.example.kurush_frontend.matching.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.databinding.FragmentMatchingCountryBinding

class MatchingCountryFragment : Fragment() {
    lateinit var binding: FragmentMatchingCountryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingCountryBinding.inflate(inflater, container, false)

        return binding.root
    }

}