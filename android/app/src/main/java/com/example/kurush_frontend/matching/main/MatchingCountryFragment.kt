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
import com.example.kurush_frontend.databinding.FragmentMatchingCountryBinding
import com.example.kurush_frontend.matching.add.MatchingAddFragment
import com.example.kurush_frontend.matching.main.adapter.HorizonRVAdapter
import com.example.kurush_frontend.matching.main.adapter.VerticalRVAdapter
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchingCountryFragment : Fragment() {
    lateinit var binding: FragmentMatchingCountryBinding
    lateinit var dummyItemsHor : MatchingDataList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingCountryBinding.inflate(inflater, container, false)

        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)

        service.postNation().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if(response.isSuccessful){
                    val result = response.body()
                    if(result!=null){
                        Log.d("user", result.toString())
                        val dummyItemsVer = PostDataList(result.data)
                        val itemssV : List<PostData> = dummyItemsVer.data
                        binding.rvMatchingCountryVertical.adapter = VerticalRVAdapter(itemssV)

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
        binding.rvMatchingCountryHorizon.adapter = HorizonRVAdapter(items)


        binding.ivMatchingCountryAddBtn.setOnClickListener{
            binding.ivMatchingCountryAddBtn.setImageResource(R.drawable.btn_add_match_select)

            parentFragment?.parentFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frm, MatchingAddFragment())
                ?.commit()

        }

        return binding.root
    }

}