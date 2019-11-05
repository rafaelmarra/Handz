package com.marrapps.handz.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.Repository
import com.marrapps.handz.model.retrofit.NumbersServiceListener

class NumberListViewModel(private val repository: Repository): ViewModel(), NumbersServiceListener {

    val numberList = MutableLiveData<List<Int>>()
    val numberError = MutableLiveData<Repository.ErrorType>()

    fun getNumbers(){
        repository.getNumbers(this)
    }

    override fun onSuccess(response: NumbersResponse) {
        numberList.value = response.numbers
    }

    override fun onError(error: Repository.ErrorType) {
        numberError.value = error
    }
}