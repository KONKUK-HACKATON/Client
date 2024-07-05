package com.example.kurush_frontend.matching.write

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.request.WritePostRequest
import com.example.kurush_frontend.data.response.WritePostResponse
import com.example.kurush_frontend.databinding.FragmentWriteMatchingBinding
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.truncate

class WriteMatchingFragment : Fragment() {
    lateinit var binding: FragmentWriteMatchingBinding
    private var flag = ""
//    private var


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteMatchingBinding.inflate(layoutInflater, container, false)
        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)

        binding.ivMatchingAddBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MatchingMainFragment())
                .commit()
        }

        var f1 =true
        var f2 = true
        var f3 = true
        var f4 = true
        binding.flWriteMatching1.setOnClickListener {
            flag = "Country"
            if(f1) {
                binding.ivWriteBtnStudy.visibility = View.GONE
                binding.ivWriteBtnStudySel.visibility = View.VISIBLE
                f1 = false
            }else{
                binding.ivWriteBtnStudy.visibility = View.VISIBLE
                binding.ivWriteBtnStudySel.visibility = View.GONE
                f1 = true
            }
        }

        binding.flWriteMatching2.setOnClickListener {
            flag = "lifestyle"
            if(f2) {
                binding.ivWriteBtnHabit.visibility = View.GONE
                binding.ivWriteBtnHabitSel.visibility = View.VISIBLE
                f2 = false
            }else {
                binding.ivWriteBtnHabit.visibility = View.VISIBLE
                binding.ivWriteBtnHabitSel.visibility = View.GONE
                f2 = true
            }
        }

        binding.flWriteMatching3.setOnClickListener {
            flag = "nation"
            if(f3) {
                binding.ivWriteBtnCountry.visibility = View.GONE
                binding.ivWriteBtnCountrySel.visibility = View.VISIBLE
                f3 = false
            }else {
                binding.ivWriteBtnCountry.visibility = View.VISIBLE
                binding.ivWriteBtnCountrySel.visibility = View.GONE
                f3 = true
            }
        }

        binding.flWriteMatching4.setOnClickListener {
            flag = "free"
            if(f4) {
                binding.ivWriteBtnFree.visibility = View.GONE
                binding.ivWriteBtnFreeSel.visibility = View.VISIBLE
                f4 = false
            }else{
                binding.ivWriteBtnFree.visibility = View.VISIBLE
                binding.ivWriteBtnFreeSel.visibility = View.GONE
                f4 = true
        }}

        binding.ivWriteMatchingUpload.setOnClickListener {
            val writePostRequest = WritePostRequest(
                "경민",
                binding.etWriteMatchingTitle.text.toString(),
                binding.etWriteMatchingContents.text.toString(),
                false,
                false,
                flag
            )

            service.writePost(
                writePostRequest
            ).enqueue(object : Callback<WritePostResponse> {
                override fun onResponse(
                    call: Call<WritePostResponse>,
                    response: Response<WritePostResponse>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        if (result != null) {
                            Log.d("res", result.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<WritePostResponse>, t: Throwable) {
                    Log.d("e","e")
                }
            })



            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MatchingMainFragment())
                .commit()
        }


        return binding.root
    }
}