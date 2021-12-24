package com.santimattius.kmm.marvel

import com.santimattius.kmm.marvel.domain.usecases.FindCharacter
import com.santimattius.kmm.marvel.domain.usecases.GetCharacters
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MarvelSDK : KoinComponent {

    private val findCharacter: FindCharacter by inject()
    private val getCharacters: GetCharacters by inject()

    suspend fun findCharacterById(id: Long) = findCharacter(id)

    suspend fun getCharactersPage(offset: Long, limit: Long) = getCharacters(offset, limit)
}