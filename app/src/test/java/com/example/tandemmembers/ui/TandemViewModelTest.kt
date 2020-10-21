package com.example.tandemmembers.ui

import androidx.lifecycle.ViewModel
import com.example.tandemmembers.model.TandemRepository
import com.example.tandemmembers.testModule
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject


class TandemViewModelTest(
    private val repository: TandemRepository
) : KoinTest {

    private val viewModel: TandemViewModel by inject()

    @get: Rule
    val kointTestRule = KoinTestRule.create{
        modules(testModule)
    }

}