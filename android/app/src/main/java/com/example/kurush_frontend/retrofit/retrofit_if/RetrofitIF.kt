package com.example.kurush_frontend.retrofit.retrofit_if

import com.example.kurush_frontend.data.request.LoginRequest
import com.example.kurush_frontend.data.request.MatchingAddRequest
import com.example.kurush_frontend.data.response.LoginResponse
import com.example.kurush_frontend.data.response.OKReponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

public interface RetrofitIF {

    @POST("/matchings/add")
    fun addMatchingList(
        @Header("Authorization: JWT")
        @Body matchingAddRequest: MatchingAddRequest
    ): Call<OKReponse>

    @POST("/login")
    fun login(
        @Body loginRequest: LoginRequest,
        ) : Call<LoginResponse>

    @POST("/communities/create")
    fun writePost()




}