package com.example.domain.di

import com.example.domain.usecase.ListPostUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory { ListPostUseCase(get(), get()) }

    single { CoroutineScope(Dispatchers.IO) }
}