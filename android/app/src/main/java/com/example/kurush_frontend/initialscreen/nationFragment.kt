package com.example.kurush_frontend.initialscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentNationBinding

class nationFragment : Fragment() {
    lateinit var binding:FragmentNationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNationBinding.inflate(inflater,container,false)
        binding.ivNextBtnNation.setOnClickListener{
            val fragment=eatingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_frame,fragment)
                .commit()
        }
        return binding.root
    }

}