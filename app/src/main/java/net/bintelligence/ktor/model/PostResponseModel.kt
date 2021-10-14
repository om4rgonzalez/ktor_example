package net.bintelligence.ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponseModel(
    val userId: Int,
    val id: Int,
    val title:String,
    val body: String
)
