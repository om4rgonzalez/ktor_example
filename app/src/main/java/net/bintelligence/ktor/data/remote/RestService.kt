package net.bintelligence.ktor.data.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.BodyProgress.Feature.install
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import net.bintelligence.ktor.model.PostResponseModel

interface RestService {

    suspend fun getPosts(): MutableList<PostResponseModel>
    suspend fun addPost(newPost: PostResponseModel): PostResponseModel?

    companion object{
        fun create(): RestService{
            return RestServiceImpl(client = HttpClient(Android){
                install(Logging){
                    level = LogLevel.ALL
                }
                install(JsonFeature){
                    serializer = KotlinxSerializer()
                }
            })
        }
    }
}