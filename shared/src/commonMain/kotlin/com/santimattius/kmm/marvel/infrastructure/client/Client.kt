package com.santimattius.kmm.marvel.infrastructure.client

import com.santimattius.kmm.marvel.di.Credentials
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json

private const val API_KEY = "apikey"
private const val TS = "ts"
private const val HASH = "hash"

internal fun ktorHttpClient(credentials: Credentials) = HttpClient {

    install(JsonFeature) {
        serializer = KotlinxSerializer(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    val now = Clock.System.now()
    val hash =
        generateHash(now.toEpochMilliseconds(), credentials.privateKey, credentials.publicKey)

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        parameter(API_KEY, credentials.publicKey)
        parameter(TS, now.toString())
        parameter(HASH, hash)
    }
}