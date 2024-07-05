package com.example.kurush_frontend.initialscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentDepartmentBinding

class departmentFragment : Fragment() {
    lateinit var binding:FragmentDepartmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDepartmentBinding.inflate(inflater,container,false)
        setupSpinner()
        return binding.root
    }

    fun setupSpinner() {
        val spinner :Spinner = binding.spCollege

        val collegeItems = arrayOf("문과대학", "이과대학", "건축대학","공과대학","사회과학대학","경영대학","부동산과학원","KU융합과학기술원","상허생명과학대학")

        val adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, collegeItems)

        spinner.adapter = adapter

    }
}