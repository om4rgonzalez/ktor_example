package com.example.data.datasource.remote.request

import com.example.data.datasource.remote.response.PostDto

data class PostRequest(val wall: Wall)

data class Wall(val id: Int = 0, val post: PostDto)