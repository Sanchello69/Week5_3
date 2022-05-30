package com.vas.feature_main_screen.data.pagingSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vas.feature_main_screen.data.network.Api
import com.vas.feature_main_screen.domain.model.CatModel

const val NETWORK_PAGE_SIZE = 10

class CatListPagingSource (
    private val api: Api) :
    PagingSource<Int, CatModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatModel> {

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(NETWORK_PAGE_SIZE)

        val response = api.getMainResult(page)
        if (response.isNotEmpty()){
            val cats = response.map {
                CatModel(
                    id = it.id,
                    url = it.url
                )
            }
            val nextKey = if (cats.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(cats, prevKey, nextKey)
        } else {
            return LoadResult.Page(emptyList(), 0, 2)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CatModel>): Int? {
        return 1
    }
}