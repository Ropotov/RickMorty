package ru.nikita.rickmorty.data

import androidx.lifecycle.LiveData
import ru.nikita.rickmorty.api.RetrofitInstance

class Repository {

    fun getCharacter(): LiveData<Character> {
        return RetrofitInstance.Api.getCharacter()
    }
}


