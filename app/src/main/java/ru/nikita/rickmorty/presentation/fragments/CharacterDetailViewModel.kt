package ru.nikita.rickmorty.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikita.rickmorty.domain.GetDetailCharacterUseCase
import ru.nikita.rickmorty.domain.model.Result
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    private val getDetailCharacterUseCase: GetDetailCharacterUseCase
) : ViewModel() {

    val characterDetailLD: MutableLiveData<Result> = MutableLiveData()

    fun getDetailCharacter(id: Int) {
        viewModelScope.launch {
            characterDetailLD.value = getDetailCharacterUseCase.getDetailCharacter(id)
        }
    }
}