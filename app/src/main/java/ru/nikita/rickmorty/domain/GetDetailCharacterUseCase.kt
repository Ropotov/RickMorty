package ru.nikita.rickmorty.domain


import ru.nikita.rickmorty.domain.model.Result

class GetDetailCharacterUseCase(private val repository: CharacterRepository) {

    suspend fun getDetailCharacter(id: Int): Result {
       return repository.getDetailCharacter(id)
    }
}