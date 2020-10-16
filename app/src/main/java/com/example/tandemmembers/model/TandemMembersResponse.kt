package com.example.tandemmembers.model

data class TandemMembersResponse(
    val errorCode: Any,
    val response: List<TandemMember>,
    val type: String
)