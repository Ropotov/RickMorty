package ru.nikita.rickmorty.data

import ru.nikita.rickmorty.api.RetrofitInstance

class Repository {

    suspend fun getCharacter(): Character {
        return RetrofitInstance.Api.getCharacter()
    }
}


