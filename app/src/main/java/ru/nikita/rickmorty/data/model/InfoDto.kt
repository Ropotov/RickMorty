package ru.nikita.rickmorty.data.model

data class InfoDto(
    var count: Int?,
    var next: String?,
    var pages: Int?,
    var prev: Int?
)