package ru.nikita.rickmorty.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikita.rickmorty.data.Repository

class CharacterListViewModel : ViewModel() {

    private val repository = Repository()
    val characterLD: MutableLiveData<ru.nikita.rickmorty.data.Character> = MutableLiveData()

    init {
        getCharacter()
    }

    private fun getCharacter() {
    viewModelScope.launch(){
        characterLD.value = repository.getCharacter()
    }
    }

}