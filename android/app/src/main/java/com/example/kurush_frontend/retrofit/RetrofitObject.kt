package com.example.kurush_frontend.retrofit

import android.util.Log
import com.example.kurush_frontend.data.initData
import com.example.kurush_frontend.databinding.FragmentDepartmentBinding
import com.example.kurush_frontend.retrofit.retrofit_if.initIF
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "http://13.125.122.128:8080/"

    val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(initIF::class.java)

    fun sendDataToServer(initData: initData) {
        val service = RetrofitObject.service

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val call: Call<initData> = service.postInitialSettings(initData)
                call.enqueue(object : Callback<initData> {
                    override fun onResponse(call: Call<initData>, response: Response<initData>) {
                        if (response.isSuccessful) {
                            val responseData = response.body()
                            // 성공적으로 데이터를 전송한 후 필요한 처리 추가
                        } else {
                            val errorBody = response.errorBody()
                            // 오류 처리 로직을 추가하세요
                        }
                    }

                    override fun onFailure(call: Call<initData>, t: Throwable) {
                        Log.d("실패", t.message.toString())
                        t.printStackTrace()
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
