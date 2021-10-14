package net.bintelligence.ktor.data.remote

import io.ktor.client.*
import io.ktor.client.request.*
import net.bintelligence.ktor.model.PostResponseModel

class RestServiceImpl(private val client: HttpClient): RestService {



    override suspend fun getPosts(): MutableList<PostResponseModel> {
        return client.get{url(Routes.POSTS)}
    }
}