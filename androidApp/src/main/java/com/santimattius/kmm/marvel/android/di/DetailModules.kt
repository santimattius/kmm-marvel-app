package com.santimattius.kmm.marvel.android.di

import com.santimattius.kmm.marvel.android.detail.ui.DetailViewModel
import com.santimattius.kmm.marvel.android.detail.domain.FindCharacter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val detailAppModules = module {
    viewModel { (characterId: Long) -> DetailViewModel(id = characterId, findCharacter = get()) }
}

private val detailDomainModules = module {
    factory { FindCharacter(get()) }
}


val detailModules = listOf(detailAppModules, detailDomainModules)

