package ru.nikita.rickmorty.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikita.rickmorty.domain.GetCharacterUseCase
import ru.nikita.rickmorty.domain.model.Character
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel(){

    var isLoading = true
    val characterLD: MutableLiveData<Character> = MutableLiveData()

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch() {
            characterLD.value = getCharacterUseCase.getCharacter()
            isLoading = false
        }
    }
}