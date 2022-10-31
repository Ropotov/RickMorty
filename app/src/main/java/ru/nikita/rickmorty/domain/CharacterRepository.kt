package ru.nikita.rickmorty.domain

import ru.nikita.rickmorty.domain.model.Character

interface CharacterRepository {

    suspend fun getCharacter(): Character

}