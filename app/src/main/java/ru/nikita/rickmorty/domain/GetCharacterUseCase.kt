package ru.nikita.rickmorty.domain

import ru.nikita.rickmorty.domain.model.Character
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend fun getCharacter(): Character {
        return characterRepository.getCharacter()
    }
}