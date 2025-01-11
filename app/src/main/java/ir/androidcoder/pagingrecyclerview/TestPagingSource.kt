package ir.androidcoder.pagingrecyclerview

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

class TestPagingSource(private val response : List<TestModel>) : PagingSource<Int, TestModel>() {

    override fun getRefreshKey(state: PagingState<Int, TestModel>): Int? =
        state.anchorPosition?.let { anchor ->
        state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TestModel> = try {
        val currentPage = params.key ?: 1
        LoadResult.Page(
            data = response,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (response.isEmpty()) null else currentPage + 1
        )

    }catch (e : Exception){
        LoadResult.Error(e)
    }

}