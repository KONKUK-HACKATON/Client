package com.example.kurush_frontend.retrofit.retrofit_if

import com.example.kurush_frontend.data.initData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface initIF {
    @POST("/api/members/initial-settings")
    fun postInitialSettings(@Body initData: initData): Call<initData>
}