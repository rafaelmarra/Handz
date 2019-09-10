package com.marrapps.handz.hands

import com.marrapps.handz.model.numbers.NumbersResponse

interface HandsContract {

    interface View {

        fun fetchComplete(urlList: List<String>)
        fun onError()
    }

    interface Presenter {

        fun fetchImages(numbersResponse: NumbersResponse)
    }
}