package com.santimattius.kmm.marvel.android.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.santimattius.kmm.marvel.MarvelSDK
import com.santimattius.kmm.marvel.android.home.domain.Characters
import com.santimattius.kmm.marvel.android.home.domain.CharactersRepository
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(private val marvelSDK: MarvelSDK) :
    CharactersRepository {

    private val characters: Flow<Characters> = Pager(PagingConfig(pageSize = 20)) {
        CharactersDataSources(marvelSDK)
    }.flow

    override fun getCharacters(): Flow<Characters> = characters
}