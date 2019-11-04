package com.marrapps.handz.model.retrofit

import com.marrapps.handz.model.numbers.NumbersResponse

interface NumbersServiceListener {

    fun onSucess(response: NumbersResponse)
    fun onError(error: Repository.ErrorType)
}