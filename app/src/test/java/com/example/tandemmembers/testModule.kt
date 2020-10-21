package com.example.tandemmembers

import com.example.tandemmembers.model.TandemRepository
import com.example.tandemmembers.ui.TandemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val testModule = module {
    single<TandemRepository> {
        return@single TestRepository()
    }

    viewModel {
        TandemViewModel(get())
    }
}