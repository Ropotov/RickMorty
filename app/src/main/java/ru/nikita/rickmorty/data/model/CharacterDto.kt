package ru.nikita.rickmorty.data.model

data class CharacterDto(
    var info: InfoDto,
    var results: List<ResultDto>
)