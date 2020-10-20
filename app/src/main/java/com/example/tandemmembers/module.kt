package com.example.tandemmembers

import com.example.tandemmembers.network.ApiMembersService
import com.example.tandemmembers.data.TandemRepositoryImpl
import com.example.tandemmembers.model.TandemRepository
import com.example.tandemmembers.ui.TandemViewModel
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val tandemModule = module {

    single<TandemRepository> {
        return@single TandemRepositoryImpl(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://tandem2019.web.app/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ApiMembersService::class.java)
    }

    viewModel {
        TandemViewModel(get())
    }
}