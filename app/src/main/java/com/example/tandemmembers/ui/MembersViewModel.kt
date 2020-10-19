package com.example.tandemmembers.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tandemmembers.data.TandemRepository
import com.example.tandemmembers.model.TandemMember
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MembersViewModel(
    private val repository: TandemRepository
) : ViewModel() {

    private val _membersLiveData = MutableLiveData<List<TandemMember>>(emptyList())
    val membersLiveData: LiveData<List<TandemMember>> = _membersLiveData


    val tandemMembersLiveData = liveData(Dispatchers.IO) {
        try {
            emit(repository.getMembers())
        } catch (e: Exception) {
            println(e.message)
            println("3.6 Roentgen.")
        }
    }

}