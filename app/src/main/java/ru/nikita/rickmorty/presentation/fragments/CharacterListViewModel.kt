package ru.nikita.rickmorty.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikita.rickmorty.data.CharacterRepositoryImpl
import ru.nikita.rickmorty.domain.GetCharacterUseCase
import ru.nikita.rickmorty.domain.model.Character

class CharacterListViewModel : ViewModel() {

    private val characterRepositoryImpl = CharacterRepositoryImpl()
    private val getCharacterUseCase = GetCharacterUseCase(characterRepositoryImpl)
    val characterLD: MutableLiveData<Character> = MutableLiveData()

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch() {
            characterLD.value = getCharacterUseCase.getCharacter()
        }
    }
}