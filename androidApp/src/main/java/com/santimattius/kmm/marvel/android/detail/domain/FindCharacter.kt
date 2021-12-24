package com.santimattius.kmm.marvel.android.detail.domain

import com.santimattius.kmm.marvel.MarvelSDK

class FindCharacter(private val marvelSDK: MarvelSDK) {
    suspend operator fun invoke(id: Long) = marvelSDK.findCharacterById(id)
}