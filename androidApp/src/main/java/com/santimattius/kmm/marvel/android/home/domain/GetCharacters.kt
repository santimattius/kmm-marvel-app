package com.santimattius.kmm.marvel.android.home.domain

class GetCharacters(private val repository: CharactersRepository) {

    operator fun invoke() = repository.getCharacters()
}