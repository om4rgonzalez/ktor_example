package net.bintelligence.ktor.data.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface RestService {

    suspend fun getPosts(): MutableList<com.example.domain.model.PostResponseModel>
    suspend fun addPost(newPost: com.example.domain.model.PostResponseModel): com.example.domain.model.PostResponseModel?

    companion object {
        fun create(): RestService {
            return RestServiceImpl(client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            })
        }
    }
}