package ru.nikita.rickmorty.data

import ru.nikita.rickmorty.data.api.RetrofitInstance
import ru.nikita.rickmorty.domain.CharacterRepository
import ru.nikita.rickmorty.domain.model.Character
import ru.nikita.rickmorty.domain.model.Result

class CharacterRepositoryImpl : CharacterRepository {

    private val mapper = CharacterMapper()

    override suspend fun getCharacter(): Character {
        val character = RetrofitInstance.Api.getCharacter()
        return mapper.mapCharacterDtoToCharacter(character)
    }

    override suspend fun getDetailCharacter(id: Int): Result {
        val detailCharacter = RetrofitInstance.Api.getDetailCharacter(id)
        return mapper.mapResultsDtoToResults(detailCharacter)
    }
}