package ru.nikita.rickmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.nikita.rickmorty.api.ApiService
import ru.nikita.rickmorty.data.Result

class CharacterPageSource(
    private val apiService: ApiService,
) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize

        val response = apiService.getCharacter(page, pageSize)
        return if (response.isSuccessful) {
            val result = checkNotNull(response.body()).results
            val nextKey = if (result.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            LoadResult.Page(result, nextKey, prevKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}