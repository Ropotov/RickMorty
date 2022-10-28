package ru.nikita.rickmorty.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.nikita.rickmorty.data.Character
import ru.nikita.rickmorty.api.RetrofitInstance

class CharacterListViewModel: ViewModel() {
    var characterList: MutableLiveData<List<Character>> = MutableLiveData()

    init {
        getCharacterList()
    }

    private fun getCharacterList(){
        viewModelScope.launch {
            characterList.value = RetrofitInstance.Api.getCharacter()
        }
    }
}