package com.example.tandemmembers.data

import com.example.tandemmembers.model.TandemMember

interface TandemRepository {

    suspend fun getMembers() : List<TandemMember>
}