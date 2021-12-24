package com.santimattius.kmm.marvel.android.home.domain

import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(): Flow<Characters>
}