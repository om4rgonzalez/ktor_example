package com.example.data.datasource.remote.response

data class ErrorDto(
    val code: String? = "404",
    val message: String? = "No lo encontrĂ©",
    val isSuccess: Boolean? = false,
    val data: Any? = null
)