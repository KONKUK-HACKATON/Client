package com.example.kurush_frontend.data.response

import java.io.Serializable

data class MatchingData(
    val matchingId: Int,
    val nickname: String,
    val nation: String,
    val gender: String,
    val college: String,
    val major: String,
    val memberId: Int
) : Serializable
