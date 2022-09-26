package ru.nikita.rickmorty.data

data class Info(
    var count: Int,
    var next: String,
    var pages: Int,
    var prev: Any
)