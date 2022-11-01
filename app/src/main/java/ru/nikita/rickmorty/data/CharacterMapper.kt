package ru.nikita.rickmorty.data

import ru.nikita.rickmorty.data.model.CharacterDto
import ru.nikita.rickmorty.data.model.InfoDto
import ru.nikita.rickmorty.data.model.LocationDto
import ru.nikita.rickmorty.data.model.ResultDto
import ru.nikita.rickmorty.domain.model.Character
import ru.nikita.rickmorty.domain.model.Info
import ru.nikita.rickmorty.domain.model.Location
import ru.nikita.rickmorty.domain.model.Result


class CharacterMapper {

    private fun mapInfoDtoToInfo(infoDto: InfoDto) = Info(
        count = infoDto.count ?: EMPTY_NUMBER,
        next = infoDto.next ?: EMPTY_STRING,
        pages = infoDto.pages ?: EMPTY_NUMBER,
        prev = infoDto.prev ?: EMPTY_NUMBER,
    )

    private fun mapLocationDtoToLocation(locationDto: LocationDto) = Location(
        name = locationDto.name ?: EMPTY_STRING,
        url = locationDto.url ?: EMPTY_STRING
    )

    fun mapResultsDtoToResults(resultDto: ResultDto) = Result(
        created = resultDto.created ?: EMPTY_STRING,
        episode = resultDto.episode ?: emptyList(),
        gender = resultDto.gender ?: EMPTY_STRING,
        id = resultDto.id ?: EMPTY_NUMBER,
        image = resultDto.image ?: EMPTY_STRING,
        location = mapLocationDtoToLocation(resultDto.location),
        name = resultDto.name ?: EMPTY_STRING,
        species = resultDto.species ?: EMPTY_STRING,
        status = resultDto.status ?: EMPTY_STRING,
        type = resultDto.type ?: EMPTY_STRING,
        url = resultDto.url ?: EMPTY_STRING
    )

    private fun malListResultsDtoToListResults(list: List<ResultDto>) = list.map {
        mapResultsDtoToResults(it)
    }

    fun mapCharacterDtoToCharacter(characterDto: CharacterDto) = Character(
        info = mapInfoDtoToInfo(characterDto.info),
        results = malListResultsDtoToListResults(characterDto.results)
    )

    companion object {
        private const val EMPTY_STRING = ""
        private const val EMPTY_NUMBER = 0
    }
}