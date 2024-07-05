package com.example.kurush_frontend.matching.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.databinding.FragmentMatchingFreeBinding

class MatchingFreeFragment : Fragment() {
    lateinit var binding: FragmentMatchingFreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingFreeBinding.inflate(inflater, container, false)

        binding.rvMatchingFreeHorizon.adapter =

        return binding.root
    }

}