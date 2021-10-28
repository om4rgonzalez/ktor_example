package com.example.data.repository

import com.example.data.datasource.PostDataSource
import com.example.domain.model.PostModel
import com.example.domain.repository.PostRepository

class PostRepositoryImpl(private val local: PostDataSource, private val remote: PostDataSource) :
    PostRepository {
    override suspend fun getList(): List<PostModel> = local.getList()

    override suspend fun createPost(post: PostModel): Boolean = remote.createPost(post)
}