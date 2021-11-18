package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.model.PostModel
import com.example.domain.repository.PostRepository
import kotlinx.coroutines.CoroutineScope

class ListPostUseCase(scope: CoroutineScope, private val postRepository: PostRepository) :
    BaseUseCase<List<PostModel>, Any?>(scope) {
    override suspend fun getData(param: Any?): List<PostModel> = postRepository.getList()
}