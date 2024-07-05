package com.example.kurush_frontend.initialscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.kurush_frontend.R
import com.example.kurush_frontend.databinding.FragmentStudennumBinding

class studennumFragment : Fragment() {
    lateinit var binding:FragmentStudennumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentStudennumBinding.inflate(inflater,container,false)
        setupSpinner()
        binding.ivNextBtnStudent.setOnClickListener {
            val studentNumber=binding.spStudentNum.selectedItem.toString()
            val bundle = arguments ?: Bundle()  // 이전 번들을 가져옴
            bundle.putString("studentNumber", studentNumber)  // 새로운 데이터를 추가

            val fragment = nationFragment().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_frame,fragment)
                .commit()
        }
        return binding.root
    }

    private fun setupSpinner() {
        val spinnerStudentnum: Spinner =binding.spStudentNum
        val spinnerGender:Spinner=binding.spGender

        val studentnumItems= arrayOf("17학번 이전", "18학번","19학번","20학번","21학번","22학번","23학번","24학번")
        val genderItems= arrayOf("남","여")

        val studentnumAdapter=ArrayAdapter(requireContext(),R.layout.item_spinner,studentnumItems)
        val genderAdapter=ArrayAdapter(requireContext(),R.layout.item_spinner,genderItems)

        spinnerStudentnum.adapter=studentnumAdapter
        spinnerGender.adapter=genderAdapter
    }

}