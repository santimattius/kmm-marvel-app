package com.santimattius.kmm.marvel.domain.repositories

import com.santimattius.kmm.marvel.domain.entities.Character

internal interface CharactersRepository {

    suspend fun getCharacters(offset: Long, limit: Long): List<Character>

    suspend fun findCharacter(id: Long): Character
}