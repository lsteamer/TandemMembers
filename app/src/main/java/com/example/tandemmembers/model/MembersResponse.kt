package com.example.tandemmembers.model

data class MembersResponse(
    val errorCode: Any,
    val response: List<Member>,
    val type: String
)