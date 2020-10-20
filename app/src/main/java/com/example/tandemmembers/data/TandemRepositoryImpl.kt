package com.example.tandemmembers.data

import com.example.tandemmembers.model.TandemMember
import com.example.tandemmembers.model.TandemRepository
import com.example.tandemmembers.network.ApiMembersService

class TandemRepositoryImpl(
    private val client: ApiMembersService
) : TandemRepository {

    override suspend fun getMembers(): List<TandemMember> {
        //improve with pagination
        val list: MutableList<TandemMember> = client.getMembers(1).response.toMutableList()
        var next = 20.rem(list.size)
        var mutableSize = list.size / 20

        while (next == 0) {
            val addList = client.getMembers(1 + mutableSize).response
            list.addAll(addList)
            next = 20.rem(addList.size)
            mutableSize = list.size / 20
        }

        return list
    }
}