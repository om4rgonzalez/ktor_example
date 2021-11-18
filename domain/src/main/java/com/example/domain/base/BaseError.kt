package com.example.domain.base

data class BaseError(
    var message: String? = "",
    var code: String? = "",
    var status: Int = 200
)