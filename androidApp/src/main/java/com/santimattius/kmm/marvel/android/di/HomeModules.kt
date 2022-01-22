package com.santimattius.kmm.marvel.android.di

import com.santimattius.kmm.marvel.android.home.ui.HomeViewModel
import com.santimattius.kmm.marvel.android.home.domain.CharactersRepository
import com.santimattius.kmm.marvel.android.home.domain.GetCharacters
import com.santimattius.kmm.marvel.android.home.data.CharactersRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val homeAppModules = module {
    viewModel { HomeViewModel(getCharacters = get()) }
}

private val homeDomainModules = module {
    factory { GetCharacters(repository = get()) }
}

private val homeInfrastructureModules = module {
    factory<CharactersRepository> { CharactersRepositoryImpl(marvelSDK = get()) }
}

val homeModules = listOf(homeAppModules, homeDomainModules, homeInfrastructureModules)