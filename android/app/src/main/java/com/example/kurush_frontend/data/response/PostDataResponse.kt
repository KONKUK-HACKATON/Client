package com.example.kurush_frontend.data.response

import java.io.Serializable

data class PostResponse(
    val success: Boolean,
    val data: List<PostData>
) : Serializable