package com.example.kurush_frontend.matching.write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentWriteIssueBinding

class WriteIssueFragment : Fragment() {
    lateinit var binding: FragmentWriteIssueBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteIssueBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
}