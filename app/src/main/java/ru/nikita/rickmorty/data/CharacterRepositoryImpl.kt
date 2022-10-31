package ru.nikita.rickmorty.data

import ru.nikita.rickmorty.data.api.RetrofitInstance
import ru.nikita.rickmorty.domain.CharacterRepository
import ru.nikita.rickmorty.domain.model.Character

class CharacterRepositoryImpl: CharacterRepository{

    private val mapper = CharacterMapper()

    override suspend fun getCharacter(): Character {
        val character = RetrofitInstance.Api.getCharacter()
        return mapper.mapCharacterDtoToCharacter(character)
    }
}


