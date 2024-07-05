package com.example.kurush_frontend.matching.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.HorizonData
import com.example.kurush_frontend.data.VerticalData
import com.example.kurush_frontend.databinding.FragmentMatchingStudyBinding
import com.example.kurush_frontend.matching.add.MatchingAddFragment
import com.example.kurush_frontend.matching.main.adapter.HorizonRVAdapter
import com.example.kurush_frontend.matching.main.adapter.VerticalRVAdapter

class MatchingStudyFragment : Fragment() {
    lateinit var binding: FragmentMatchingStudyBinding
    lateinit var dummyItemsHor : ArrayList<HorizonData>
    lateinit var dummyItemsVer : ArrayList<VerticalData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingStudyBinding.inflate(inflater, container, false)

        initDummyData()

        binding.rvMatchingStudyHorizon.adapter = HorizonRVAdapter(dummyItemsHor)

        binding.rvMatchingStudyVertical.adapter = VerticalRVAdapter(dummyItemsVer)

        binding.ivMatchingStudyAddBtn.setOnClickListener{
            binding.ivMatchingStudyAddBtn.setImageResource(R.drawable.btn_add_match_select)

            parentFragment?.parentFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frm, MatchingAddFragment())
                ?.commit()

        }

        return binding.root
    }

    private fun initDummyData() {
        dummyItemsVer = ArrayList<VerticalData>()
        dummyItemsHor = ArrayList<HorizonData>()
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )
        dummyItemsHor.add(
            HorizonData("nickname", "department", "country", "gender")
        )

        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "제목", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )
        dummyItemsVer.add(
            VerticalData("nickname", "sdfs", "더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 더미데이터 "
                , 5)
        )


    }

}