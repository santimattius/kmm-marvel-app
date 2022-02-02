package com.santimattius.kmm.marvel.infrastructure.datasources

import com.santimattius.kmm.marvel.infrastructure.models.ApiResponse
import com.santimattius.kmm.marvel.infrastructure.models.Character
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class MarvelRemoteDataSource(
    private val client: HttpClient,
    private val baseUrl: String,
) : MarvelDataSource {

    override suspend fun getCharacters(offset: Long, limit: Long): ApiResponse {
        val url =
            URLBuilder(urlString = "$baseUrl/characters?offset=$offset&limit=$limit")
                .build()
        return client.get(url = url)
    }

    override suspend fun findCharacter(id: Long): Character {
        val url =
            URLBuilder(urlString = "$baseUrl/characters/$id").build()
        return client.get<ApiResponse>(url = url).data.results.first()
    }
}