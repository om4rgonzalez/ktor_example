package com.example.data.datasource.remote.response

data class ErrorDto(
    val code: String? = "404",
    val message: String? = "No lo encontré",
    val isSuccess: Boolean? = false,
    val data: Any? = null
)