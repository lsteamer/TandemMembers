package com.example.tandemmembers.data

import com.example.tandemmembers.model.TandemMember

class MembersRepository(
    private val client: ApiMembersService
) : TandemRepository {

    override suspend fun getMembers(): List<TandemMember> {
        return client.getMembers(1).response
    }
}