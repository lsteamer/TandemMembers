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


    val membersLiveData2 = liveData(Dispatchers.IO) {
        try {
            val retrievedCall = repository.getMembers()
            emit(retrievedCall)
        } catch (e: Exception) {
            println(e.message)
            println("3.6 Roentgen.")
        }
    }

    fun fetchMemberList() {
    }

    /*

        viewModelScope.launch {
            try {
                repository.getMembers(1)
            } catch (e : Exception){
                println("3.6 Roentgen.")
            }
        }

     */

}