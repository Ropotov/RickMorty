package ru.nikita.rickmorty.domain.model

data class Character(
    var info: Info,
    var results: List<Result>
)