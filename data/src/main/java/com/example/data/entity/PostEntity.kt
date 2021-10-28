package com.example.data.entity

//@Entity
data class PostEntity(
    //@ColumInfo("")
    var userId: Int = 0,
    var id: Int = 0,
    var title: String = "",
    var body: String = "",
    //@Ignore
    var images: List<ImageEntity> = listOf()
)

data class ImageEntity(val url: String = "", val postId: Int = 0)
