package ru.nikita.rickmorty.api

import retrofit2.Response
import retrofit2.http.GET
import ru.nikita.rickmorty.data.Character

interface ApiService {
    @GET("character/")
    suspend fun getCharacter(): Response<Character>
}
