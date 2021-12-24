package com.santimattius.kmm.marvel.android.home.infrastructure

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.santimattius.kmm.marvel.MarvelSDK
import com.santimattius.kmm.marvel.domain.entities.Character

class CharactersDataSources(
    private val marvelSDK: MarvelSDK
) : PagingSource<Long, Character>() {

    override fun getRefreshKey(state: PagingState<Long, Character>): Long? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Character> {
        return try {
            val nextPage = params.key ?: 1
            val response = marvelSDK.getCharactersPage(
                offset = nextPage,
                limit = params.loadSize.toLong()
            )

            val count = response.size
            val limit = params.loadSize

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1L) null else nextPage - limit,
                nextKey = if (count < limit) null else nextPage + limit,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

