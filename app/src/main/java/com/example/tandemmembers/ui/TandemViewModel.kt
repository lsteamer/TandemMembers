package com.example.tandemmembers.ui

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception

class TandemViewModel(
    private val repository: TandemRepository
) : ViewModel() {

    private var currentTandemMembers: Flow<PagingData<TandemMember>>? = null

    fun getMembers() : Flow<PagingData<TandemMember>>{
        val newTandemMembers: Flow<PagingData<TandemMember>> = repository.getTandemMembers()
            .cachedIn(viewModelScope)
        currentTandemMembers = newTandemMembers
        return newTandemMembers
    }
}