package com.example.kurush_frontend.retrofit.retrofit_if

import com.example.kurush_frontend.data.request.LoginRequest
import com.example.kurush_frontend.data.request.MatchingAddRequest
import com.example.kurush_frontend.data.response.LoginResponse
import com.example.kurush_frontend.data.response.MatchingAddResponse
import com.example.kurush_frontend.data.response.OKReponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

public interface RetrofitIF {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @POST("/matchings/add")
    fun addMatchingList(
        @Body matchingAddRequest: MatchingAddRequest
    ): Call<MatchingAddResponse>

    @POST("/login")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Call<LoginResponse>

    @POST("/communities/create")
    fun writePost()




}