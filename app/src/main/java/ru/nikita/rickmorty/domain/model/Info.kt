package ru.nikita.rickmorty.domain.model

data class Info(
    var count: Int,
    var next: String,
    var pages: Int,
    var prev: Int
)