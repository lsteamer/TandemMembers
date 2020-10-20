package com.example.tandemmembers.ui

import androidx.lifecycle.*
import com.example.tandemmembers.model.TandemRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class TandemViewModel(
    private val repository: TandemRepository
) : ViewModel() {

    val tandemMembersLiveData = liveData(Dispatchers.IO) {
        try {
            emit(repository.getMembers())
        } catch (e: Exception) {
            println(e.message)
            println("3.6 Roentgen.")
        }
    }
}