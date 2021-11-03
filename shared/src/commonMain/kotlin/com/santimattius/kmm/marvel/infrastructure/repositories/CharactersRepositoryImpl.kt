package com.santimattius.kmm.marvel.infrastructure.repositories

import com.santimattius.kmm.marvel.domain.entities.Character
import com.santimattius.kmm.marvel.domain.repositories.CharactersRepository
import com.santimattius.kmm.marvel.infrastructure.datasources.MarvelDataSource
import com.santimattius.kmm.marvel.infrastructure.models.asCharacter

internal class CharactersRepositoryImpl(
    private val marvelDataSource: MarvelDataSource
) : CharactersRepository {

    override suspend fun getCharacters(offset: Long, limit: Long): List<Character> {
        val response = marvelDataSource.getCharacters(offset, limit)
        return response.data.results.map { it.asCharacter() }
    }

    override suspend fun findCharacter(id: Long): Character {
        val response = marvelDataSource.findCharacter(id)
        return response.asCharacter()
    }
}
