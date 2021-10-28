package com.example.data.datasource.remote.response

data class PostDto(
    //@Expose("idUsuario")
    var userId: Int? = 0,
    var id: Int? = 0,
    var title: String? = "",
    var body: String? = ""
)
