package ru.nikita.rickmorty.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikita.rickmorty.data.CharacterRepositoryImpl
import ru.nikita.rickmorty.domain.GetDetailCharacterUseCase
import ru.nikita.rickmorty.domain.model.Result

class CharacterDetailViewModel : ViewModel() {

    private val characterRepositoryImpl = CharacterRepositoryImpl()
    private val getDetailCharacterUseCase = GetDetailCharacterUseCase(characterRepositoryImpl)
    val characterDetailLD: MutableLiveData<Result> = MutableLiveData()

    fun getDetailCharacter(id: Int){
        viewModelScope.launch {
            characterDetailLD.value = getDetailCharacterUseCase.getDetailCharacter(id)

        }
    }
}