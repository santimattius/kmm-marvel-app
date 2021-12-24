package com.santimattius.kmm.marvel.domain.usecases

import com.santimattius.kmm.marvel.domain.repositories.CharactersRepository

internal class GetCharacters(private val repository: CharactersRepository) {

    suspend operator fun invoke(offset: Long, limit: Long) = repository.getCharacters(offset, limit)
}