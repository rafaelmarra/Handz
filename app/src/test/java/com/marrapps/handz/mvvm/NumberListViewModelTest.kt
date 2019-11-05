package com.marrapps.handz.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.Repository
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class NumberListViewModelTest{

    private val mockRepository: Repository = mockk()
    private val viewModel = NumberListViewModel(mockRepository)

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testOnSuccess(){
        val testList = listOf(5, 6, 7, 8, 9)
        val testResponse = NumbersResponse(testList)

        viewModel.onSuccess(testResponse)

        assertEquals(testList, viewModel.numberList.value)
    }

    private fun mockk(): Repository{}

}