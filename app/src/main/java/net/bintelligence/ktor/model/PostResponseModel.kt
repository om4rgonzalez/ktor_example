package net.bintelligence.ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponseModel(
    val userId: Int = 0,
    val id: Int = 0,
    val title:String = "",
    val body: String = ""
)
