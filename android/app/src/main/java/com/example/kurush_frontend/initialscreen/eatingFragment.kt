package com.example.kurush_frontend.initialscreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.MainActivity
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.initData
import com.example.kurush_frontend.databinding.FragmentEatingBinding
import com.example.kurush_frontend.retrofit.RetrofitObject


class eatingFragment : Fragment() {
    lateinit var binding: FragmentEatingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentEatingBinding.inflate(inflater,container,false)
        binding.ivNextBtnEating.setOnClickListener {
            val singularity=binding.etEatingInput.text.toString()
            val bundle = arguments ?: Bundle()  // 이전 번들을 가져옴
            bundle.putString("singularity", singularity)
            sendDataToServer(bundle)
            val fragment=finishFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_frame,fragment)
                .commit()
        }
        return binding.root
    }

    private fun sendDataToServer(bundle: Bundle) {
        val memberId=1
        val colleage = bundle.getString("colleage") ?: ""
        val major = bundle.getString("major") ?: ""
        val studentNumber = bundle.getString("studentNumber")?: ""
        val nation = bundle.getString("nation") ?: ""
        val language = bundle.getString("language") ?: ""
        val singularity = ""  // 필요 시 추가 데이터

        val initData = initData(
            memberId,
            colleage,
            major,
            studentNumber,
            nation,
            language,
            singularity
        )

        RetrofitObject.sendDataToServer(initData)
    }

}