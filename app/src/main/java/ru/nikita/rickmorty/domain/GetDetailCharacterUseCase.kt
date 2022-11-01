package ru.nikita.rickmorty.domain

import ru.nikita.rickmorty.domain.model.Character

class GetDetailCharacterUseCase(private val repository: CharacterRepository) {

    suspend fun getDetailCharacter(id: Int):Character {
       return repository.getDetailCharacter(id)
    }
}