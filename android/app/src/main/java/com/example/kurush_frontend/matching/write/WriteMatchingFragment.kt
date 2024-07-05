package com.example.kurush_frontend.matching.write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentWriteMatchingBinding

class WriteMatchingFragment : Fragment() {
    lateinit var binding: FragmentWriteMatchingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteMatchingBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
}