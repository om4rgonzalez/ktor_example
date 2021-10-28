package com.example.domain.repository

import com.example.domain.model.PostModel

interface PostRepository {
    suspend fun getList(): List<PostModel>
    suspend fun createPost(post: PostModel): Boolean
}