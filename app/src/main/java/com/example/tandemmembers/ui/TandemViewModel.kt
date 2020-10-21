package com.example.tandemmembers.ui

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class TandemViewModel(
    private val repository: TandemRepository
) : ViewModel() {

    fun getMembers(): Flow<PagingData<TandemMember>> = repository.getTandemMembers()
        .map { pagingData ->
            pagingData.filter {user ->
                    user.referenceCnt == 0
            }
        }
        .cachedIn(viewModelScope)
}