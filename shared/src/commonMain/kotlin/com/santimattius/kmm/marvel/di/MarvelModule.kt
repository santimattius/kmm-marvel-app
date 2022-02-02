package com.santimattius.kmm.marvel.di

import com.santimattius.kmm.marvel.domain.repositories.CharactersRepository
import com.santimattius.kmm.marvel.domain.usecases.FindCharacter
import com.santimattius.kmm.marvel.domain.usecases.GetCharacters
import com.santimattius.kmm.marvel.infrastructure.client.ktorHttpClient
import com.santimattius.kmm.marvel.infrastructure.datasources.MarvelDataSource
import com.santimattius.kmm.marvel.infrastructure.datasources.MarvelRemoteDataSource
import com.santimattius.kmm.marvel.infrastructure.repositories.CharactersRepositoryImpl
import io.ktor.client.*
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initModule(credentials: Credentials, appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    loadKoinModules(commonModule + module {
        single<Credentials> { credentials }
    })
}

// called by iOS etc
fun initModule(credentials: Credentials) = initModule(credentials) {}

val commonModule = module {
    //use cases
    factory<GetCharacters> { GetCharacters(get<CharactersRepository>()) }
    factory<FindCharacter> { FindCharacter(get<CharactersRepository>()) }
    //repository
    factory<CharactersRepository> { CharactersRepositoryImpl(get<MarvelDataSource>()) }
    //data source
    factory<MarvelDataSource> {
        MarvelRemoteDataSource(
            client = get<HttpClient>(),
            baseUrl = "https://gateway.marvel.com/v1/public"
        ) }
    //client
    single<HttpClient> { ktorHttpClient(get<Credentials>()) }
}