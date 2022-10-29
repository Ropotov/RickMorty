package ru.nikita.rickmorty.api

import androidx.lifecycle.MutableLiveData
import retrofit2.http.GET
import retrofit2.http.Query
import ru.nikita.rickmorty.data.Character

interface ApiService {
    @GET("character/")
    suspend fun getCharacter(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20
    ): Character
}
