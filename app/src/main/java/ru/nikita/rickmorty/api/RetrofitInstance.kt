package ru.nikita.rickmorty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val URL = "https://rickandmortyapi.com/api/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val Api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}

