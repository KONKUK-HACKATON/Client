package com.example.kurush_frontend.data.request

data class MatchingAddRequest(
    val nickname: String,
    val nation: String,
    val gender: String,
    var college: String,
    var major: String
)
