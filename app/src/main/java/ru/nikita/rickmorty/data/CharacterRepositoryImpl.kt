package ru.nikita.rickmorty.data

import ru.nikita.rickmorty.data.api.ApiService
import ru.nikita.rickmorty.domain.CharacterRepository
import ru.nikita.rickmorty.domain.model.Character
import ru.nikita.rickmorty.domain.model.Result
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val mapper: CharacterMapper,
    private val apiService: ApiService
) : CharacterRepository {

    override suspend fun getCharacter(): Character {
        val character = apiService.getCharacter()
        return mapper.mapCharacterDtoToCharacter(character)
    }

    override suspend fun getDetailCharacter(id: Int): Result {
        val detailCharacter = apiService.getDetailCharacter(id)
        return mapper.mapResultsDtoToResults(detailCharacter)
    }
}