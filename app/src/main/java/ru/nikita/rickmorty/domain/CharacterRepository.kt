package ru.nikita.rickmorty.domain

import ru.nikita.rickmorty.domain.model.Character
import ru.nikita.rickmorty.domain.model.Result

interface CharacterRepository {

    suspend fun getCharacter(): Character
    suspend fun getDetailCharacter(id: Int):Result

}