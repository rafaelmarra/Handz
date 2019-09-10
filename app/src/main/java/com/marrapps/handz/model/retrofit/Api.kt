package com.marrapps.handz.model.retrofit

import com.marrapps.handz.model.numbers.NumbersResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("numbers")
    fun getNumbers(): Call<NumbersResponse>
}