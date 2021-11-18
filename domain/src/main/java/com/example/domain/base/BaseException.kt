package com.example.domain.base

import java.io.IOException

data class BaseException(
    val error: BaseError = BaseError(),
    override val message: String = error.message ?: ""
) : IOException()