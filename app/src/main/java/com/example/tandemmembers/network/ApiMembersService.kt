package com.example.tandemmembers.network

import com.example.tandemmembers.model.TandemMembersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMembersService {

    @GET("community_{page}.json")
    suspend fun getMembers(@Path("page") page: Int) : TandemMembersResponse
}