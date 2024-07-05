package com.example.kurush_frontend.initialscreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.MainActivity
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
        binding.ivNextBtnNation.setOnClickListener {
            val fragment=finishFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_frame,fragment)
                .commit()
        }
        return binding.root
    }

}