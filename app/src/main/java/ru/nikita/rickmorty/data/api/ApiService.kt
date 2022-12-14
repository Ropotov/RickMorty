package ru.nikita.rickmorty.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.nikita.rickmorty.data.model.CharacterDto
import ru.nikita.rickmorty.data.model.ResultDto

interface ApiService {
    @GET("character/")
    suspend fun getCharacter(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20
    ): CharacterDto

    @GET("character/{id}")
    suspend fun getDetailCharacter(
        @Path("id") id: Int
    ): ResultDto
}