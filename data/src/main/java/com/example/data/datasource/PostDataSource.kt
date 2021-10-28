package com.example.data.datasource

import com.example.domain.model.PostModel

interface PostDataSource {
    suspend fun getList(): List<PostModel>
    suspend fun createPost(post: PostModel): Boolean
}