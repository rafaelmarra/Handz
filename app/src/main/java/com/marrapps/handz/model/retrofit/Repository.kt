package com.marrapps.handz.model.retrofit

import android.content.Context
import android.util.Log
import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.utils.isConnected
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val context: Context) {

    enum class ErrorType {
        CONNECTION_ERROR,
        API_ERROR
    }

    fun getNumbers(listener: NumbersServiceListener) {

        if (context.isConnected()) {

            val call = RetrofitService.getService().getNumbers()
            call.enqueue(object : Callback<NumbersResponse> {

                override fun onResponse(
                    call: Call<NumbersResponse>,
                    response: Response<NumbersResponse>
                ) {
                    response.body()?.let {
                        listener.onSuccess(it)

                    } ?: listener.onError(ErrorType.API_ERROR)
                }

                override fun onFailure(call: Call<NumbersResponse>, t: Throwable) {
                    Log.e("NUMBER REQUEST", t.message ?: "undefined error")
                    listener.onError(ErrorType.API_ERROR)
                }
            })

        } else {
            listener.onError(ErrorType.CONNECTION_ERROR)
        }
    }
}