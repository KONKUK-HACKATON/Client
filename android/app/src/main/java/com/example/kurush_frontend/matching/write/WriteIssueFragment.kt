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
import com.example.kurush_frontend.databinding.FragmentWriteIssueBinding
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WriteIssueFragment : Fragment() {
    lateinit var binding: FragmentWriteIssueBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteIssueBinding.inflate(layoutInflater, container, false)

        binding.ivIssueAddBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MatchingMainFragment())
                .commit()
        }

        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)

        binding.ivWriteIssueUpload.setOnClickListener {
            val writePostRequest = WritePostRequest(
                "경민",
                binding.etWriteIssueTitle.text.toString(),
                binding.etWriteIssueContents.text.toString(),
                false,
                true,
                ""
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