package net.bintelligence.ktor.data.remote

import android.util.Log
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import net.bintelligence.ktor.model.PostResponseModel

class RestServiceImpl(private val client: HttpClient): RestService {



    override suspend fun getPosts(): MutableList<PostResponseModel> {
        return try {
            client.get {
                url(Routes.POSTS)
            }
        } catch (e: RedirectResponseException){
            //3xx Errors
                Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf<PostResponseModel>()
        } catch (e: ClientRequestException){
            //4xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf<PostResponseModel>()
        } catch (e: ServerResponseException){
            //5xx errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            mutableListOf<PostResponseModel>()
        } catch (e: Exception){
            //for all
            Log.d("_ERROR_", "Error: ${e.message}")
            mutableListOf<PostResponseModel>()
        }
    }

    override suspend fun addPost(newPost: PostResponseModel): PostResponseModel? {
        return try {
            client.post<PostResponseModel>(){
                url(Routes.POSTS)
                contentType(ContentType.Application.Json)
                body = newPost
            }
        } catch (e: RedirectResponseException){
            //3xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException){
            //4xx Errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException){
            //5xx errors
            Log.d("_ERROR_", "Error: ${e.response.status.description}")
            null
        } catch (e: Exception){
            //for all
            Log.d("_ERROR_", "Error: ${e.message}")
            null
        }
    }
}