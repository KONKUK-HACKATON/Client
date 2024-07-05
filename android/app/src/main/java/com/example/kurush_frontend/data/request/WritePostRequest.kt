package com.example.kurush_frontend.data.request

data class WritePostRequest(
    val nickname: String,
    val title: String,
    val content: String,
    val isOpen: Boolean,
    val isInfo: Boolean,
    val category: String
)
