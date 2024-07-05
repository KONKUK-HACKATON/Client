package com.example.kurush_frontend.initialscreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.MainActivity
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentFinishBinding

class finishFragment : Fragment() {
    lateinit var binding:FragmentFinishBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFinishBinding.inflate(inflater,container,false)
        binding.ivFinishView.setOnClickListener {
            val intent= Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}