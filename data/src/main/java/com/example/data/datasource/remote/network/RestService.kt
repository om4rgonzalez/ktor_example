package com.example.data.datasource.remote.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface RestService {
    suspend fun getPosts(): MutableList<com.example.domain.model.PostModel>
    suspend fun addPost(newPost: com.example.domain.model.PostModel): com.example.domain.model.PostModel?

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