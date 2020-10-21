package com.example.tandemmembers.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import com.example.tandemmembers.network.ApiMembersService
import com.example.tandemmembers.TANDEM_MAX_PAGE_VALUES
import kotlinx.coroutines.flow.Flow

class TandemRepositoryImpl(
    private val service: ApiMembersService
) : TandemRepository {

    override fun getTandemMembers(): Flow<PagingData<TandemMember>> {
        return Pager(
            config = PagingConfig(pageSize = TANDEM_MAX_PAGE_VALUES),
            pagingSourceFactory = {TandemPagingSource(service)}
        ).flow
    }
}