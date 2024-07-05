package com.example.kurush_frontend.retrofit.retrofit_if

import com.example.kurush_frontend.data.request.LoginRequest
import com.example.kurush_frontend.data.request.MatchingAddRequest
import com.example.kurush_frontend.data.request.WritePostRequest
import com.example.kurush_frontend.data.response.LoginResponse
import com.example.kurush_frontend.data.response.MatchingAddResponse
import com.example.kurush_frontend.data.response.MatchingDataResponse
import com.example.kurush_frontend.data.response.OKReponse
import com.example.kurush_frontend.data.response.PostResponse
import com.example.kurush_frontend.data.response.WritePostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
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

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @POST("/communities/create")
    fun writePost(
        @Body writePostRequest: WritePostRequest
    ): Call<WritePostResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @GET("/matchings")
    fun getMatchingList(): Call<MatchingDataResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @GET("/communities/lifestyle")
    fun postLifeStyle(): Call<PostResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @GET("/communities/nation")
    fun postNation(): Call<PostResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @GET("/communities/free")
    fun postFree(): Call<PostResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiJ0ZXN0IiwiaWF0IjoxNzIwMjAzNDgxLCJleHAiOjE3MjAyMzk0ODF9.qap_iljOK1WZPCTBiRglp7cmgmFFUUvN3gN-HhlbR84")
    @GET("/communities/study")
    fun postStudy(): Call<PostResponse>




}