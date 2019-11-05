package com.marrapps.handz.splash

import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.Repository
import com.marrapps.handz.model.retrofit.NumbersServiceListener

class SplashPresenter(
    private val repository: Repository,
    private val view: SplashContract.View
) : SplashContract.Presenter, NumbersServiceListener {

    override fun fetchNumbers() {
        repository.getNumbers(this)
    }

    override fun onSuccess(response: NumbersResponse) {
        view.onNumbersResponse(response)
    }

    override fun onError(error: Repository.ErrorType) {
        when (error) {
            Repository.ErrorType.API_ERROR -> view.onApiError()
            Repository.ErrorType.CONNECTION_ERROR -> view.onConnectionError()
        }
    }
}