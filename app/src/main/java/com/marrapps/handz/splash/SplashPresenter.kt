package com.marrapps.handz.splash

import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.Repository
import com.marrapps.handz.model.retrofit.ServiceListener

class SplashPresenter(
    private val repository: Repository,
    private val view: SplashContract.View
) : SplashContract.Presenter, ServiceListener {

    init {
        repository.listener = this
    }

    override fun fetchNumbers() {
        repository.getNumbers()
    }

    override fun onSucess(response: Any) {
        view.onNumbersResponse(response as NumbersResponse)
    }

    override fun onError(error: Repository.ErrorType) {
        when (error) {
            Repository.ErrorType.API_ERROR -> view.onApiError()
            Repository.ErrorType.CONNECTION_ERROR -> view.onConnectionError()
        }
    }
}