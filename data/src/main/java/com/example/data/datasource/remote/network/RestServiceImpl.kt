package com.example.data.datasource.remote.network

import android.util.Log
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class RestServiceImpl(private val client: HttpClient) : RestService {
    override suspend fun getPosts(): MutableList<com.example.domain.model.PostModel> {
        return try {
            client.get {
                url(Routes.POSTS)
            }
        } catch (e: RedirectResponseException) {
            //3xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf()
        } catch (e: ClientRequestException) {
            //4xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf()
        } catch (e: ServerResponseException) {
            //5xx errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf()
        } catch (e: Exception) {
            //for all
            Log.d("_ERROR_", "Error: ${e.message}")
            mutableListOf()
        }
    }

    override suspend fun addPost(newPost: com.example.domain.model.PostModel): com.example.domain.model.PostModel? {
        return try {
            client.post<com.example.domain.model.PostModel> {
                url(Routes.POSTS)
                contentType(ContentType.Application.Json)
                body = newPost
            }
        } catch (e: RedirectResponseException) {
            //3xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            //4xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            //5xx errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            //for all
            Log.d("_ERROR_", "Error: ${e.message}")
            null
        }
    }
}