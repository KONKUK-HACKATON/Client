package com.example.kurush_frontend.matching.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.HorizonData
import com.example.kurush_frontend.data.VerticalData
import com.example.kurush_frontend.data.response.MatchingData
import com.example.kurush_frontend.data.response.MatchingDataList
import com.example.kurush_frontend.data.response.PostData
import com.example.kurush_frontend.data.response.PostDataList
import com.example.kurush_frontend.data.response.PostResponse
import com.example.kurush_frontend.databinding.FragmentMatchingStudyBinding
import com.example.kurush_frontend.matching.add.MatchingAddFragment
import com.example.kurush_frontend.matching.main.adapter.HorizonRVAdapter
import com.example.kurush_frontend.matching.main.adapter.VerticalRVAdapter
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchingStudyFragment : Fragment() {
    lateinit var binding: FragmentMatchingStudyBinding
    lateinit var dummyItemsHor : MatchingDataList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingStudyBinding.inflate(inflater, container, false)

        var dummyItemsVer : PostDataList
        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)

        service.postStudy().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if(response.isSuccessful){
                    val result = response.body()
                    if(result!=null){
                        Log.d("user", result.toString())
                        dummyItemsVer = PostDataList(result.data)
                        val itemssV : List<PostData> = dummyItemsVer.data
                        binding.rvMatchingStudyVertical.adapter = VerticalRVAdapter(itemssV)

                    }
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        Log.d("arg", arguments.toString())
        dummyItemsHor = arguments?.getSerializable("matchDataList") as MatchingDataList


        val items : List<MatchingData> = dummyItemsHor.data

        binding.rvMatchingStudyHorizon.adapter = HorizonRVAdapter(items)


        binding.ivMatchingStudyAddBtn.setOnClickListener{
            binding.ivMatchingStudyAddBtn.setImageResource(R.drawable.btn_add_match_select)

            parentFragment?.parentFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frm, MatchingAddFragment())
                ?.commit()

        }

        return binding.root
    }



}