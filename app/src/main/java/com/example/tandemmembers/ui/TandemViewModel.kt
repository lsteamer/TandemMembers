package com.example.tandemmembers.ui

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import kotlinx.coroutines.flow.Flow

class TandemViewModel(
    private val repository: TandemRepository
) : ViewModel() {


    fun getMembers() : Flow<PagingData<TandemMember>>{
        val newTandemMembers: Flow<PagingData<TandemMember>> = repository.getTandemMembers()
            .cachedIn(viewModelScope)
        return newTandemMembers
    }
}