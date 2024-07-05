package com.example.kurush_frontend.initialscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentEatingBinding
import com.example.kurush_frontend.databinding.FragmentNationBinding

class eatingFragment : Fragment() {
    lateinit var binding: FragmentEatingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentEatingBinding.inflate(inflater,container,false)
        return binding.root
    }

}