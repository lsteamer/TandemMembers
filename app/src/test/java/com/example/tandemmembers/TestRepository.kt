package com.example.tandemmembers

import androidx.paging.PagingData
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TestRepository : TandemRepository {
    override fun getTandemMembers(): Flow<PagingData<TandemMember>> {
        return flowOf()
    }
}