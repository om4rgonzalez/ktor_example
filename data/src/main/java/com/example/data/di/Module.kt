package com.example.data.di

import com.example.data.datasource.remote.network.RestService
import com.example.data.repository.PostRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    factory { PostRepositoryImpl(get(), get()) }

    //Inyectar ktor
    single {
        val restService: RestService = get()
        //restService.
    }
}