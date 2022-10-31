package ru.nikita.rickmorty.data.model

data class ResultDto(
    var created: String?,
    var episode: List<String>?,
    var gender: String?,
    var id: Int?,
    var image: String?,
    var location: LocationDto,
    var name: String?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?
)