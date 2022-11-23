package ru.nikita.rickmorty.domain


import ru.nikita.rickmorty.domain.model.Result
import javax.inject.Inject

class GetDetailCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend fun getDetailCharacter(id: Int): Result {
        return repository.getDetailCharacter(id)
    }
}