package com.example.tandemmembers.data

import androidx.paging.PagingSource
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.network.ApiMembersService
import com.example.tandemmembers.util.TANDEM_MAX_PAGE_VALUES
import com.example.tandemmembers.util.TANDEM_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException


class TandemPagingSource(
    private val service: ApiMembersService
) : PagingSource<Int, TandemMember>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TandemMember> {
        val position = params.key ?: TANDEM_STARTING_PAGE_INDEX
        return try {
            val fullResponse = service.getMembers(position)
            val tandemMembers = fullResponse.response
            LoadResult.Page(
                data = tandemMembers,
                prevKey = if (position == TANDEM_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (tandemMembers.size != TANDEM_MAX_PAGE_VALUES) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}