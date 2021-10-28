package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PostModel(
    //
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
)
