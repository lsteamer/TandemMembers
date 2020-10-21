package com.example.tandemmembers.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface TandemRepository {

    fun getTandemMembers(): Flow<PagingData<TandemMember>>
}