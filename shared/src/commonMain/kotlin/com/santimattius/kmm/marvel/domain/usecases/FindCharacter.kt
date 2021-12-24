package com.santimattius.kmm.marvel.domain.usecases

import com.santimattius.kmm.marvel.domain.repositories.CharactersRepository

internal class FindCharacter(private val repository: CharactersRepository) {
    suspend operator fun invoke(id: Long) = repository.findCharacter(id)
}