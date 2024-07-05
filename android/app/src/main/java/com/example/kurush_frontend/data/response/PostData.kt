package com.example.kurush_frontend.data.response

import java.io.Serializable

data class PostData(
    val postId: Int,
    val nickname: String,
    val title: String,
    val content: String,
    val isOpen: Boolean,
    val isInfo: Boolean,
    val category: String
) : Serializable