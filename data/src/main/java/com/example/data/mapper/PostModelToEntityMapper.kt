package com.example.data.mapper

import com.example.data.entity.PostEntity
import com.example.domain.model.PostModel

fun PostModelToEntityMapper(): PostEntity = PostEntity()

fun PostEntityToModelMapper(): PostModel = PostModel()
