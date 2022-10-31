package ru.nikita.rickmorty.domain

import ru.nikita.rickmorty.domain.model.Character

class GetCharacterUseCase(private val characterRepository: CharacterRepository) {

    suspend fun getCharacter(): Character {
        return characterRepository.getCharacter()
    }
}