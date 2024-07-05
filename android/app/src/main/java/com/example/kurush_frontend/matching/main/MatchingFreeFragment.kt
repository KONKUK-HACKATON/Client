package com.example.kurush_frontend.matching.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.data.HorizonData
import com.example.kurush_frontend.data.VerticalData
import com.example.kurush_frontend.databinding.FragmentMatchingFreeBinding
import com.example.kurush_frontend.matching.main.adapter.HorizonRVAdapter
import com.example.kurush_frontend.matching.main.adapter.VerticalRVAdapter

class MatchingFreeFragment : Fragment() {
    lateinit var binding: FragmentMatchingFreeBinding
    lateinit var dummyItemsHor : ArrayList<HorizonData>
    lateinit var dummyItemsVer : ArrayList<VerticalData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingFreeBinding.inflate(inflater, container, false)

        initDummyData()
        
        binding.rvMatchingFreeHorizon.adapter = HorizonRVAdapter(dummyItemsHor)

        binding.rvMatchingFreeVertical.adapter = VerticalRVAdapter(dummyItemsVer)

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