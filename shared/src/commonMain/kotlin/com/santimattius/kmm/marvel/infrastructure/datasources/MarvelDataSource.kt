package com.santimattius.kmm.marvel.infrastructure.datasources

import com.santimattius.kmm.marvel.infrastructure.models.ApiResponse
import com.santimattius.kmm.marvel.infrastructure.models.Character

interface MarvelDataSource {
    suspend fun getCharacters(offset: Long, limit: Long): ApiResponse
    suspend fun findCharacter(id: Long): Character
}