package com.marrapps.handz.splash

import com.marrapps.handz.model.numbers.NumbersResponse

interface SplashContract {

    interface Presenter {

        fun fetchNumbers()
    }

    interface View {

        fun onNumbersResponse(numbersResponse: NumbersResponse)
        fun onApiError()
        fun onConnectionError()
    }
}