package com.example.kurush_frontend.data

import com.google.gson.annotations.SerializedName

data class initData(
    @SerializedName("memberId")
    val memberId:Int,
    @SerializedName("colleage")
    val colleage:String,
    @SerializedName("major")
    val major:String,
    @SerializedName("studentNumber")
    val studentNumber:String,
    @SerializedName("nation")
    val nation:String,
    @SerializedName("language")
    val language:String,
    @SerializedName("singularity")
    val singularity:String
)