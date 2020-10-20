package com.example.tandemmembers.model

interface TandemRepository {

    suspend fun getMembers() : List<TandemMember>
}