package com.marrapps.handz.model.retrofit

interface ServiceListener {

    fun onSucess(response: Any)
    fun onError(error: Repository.ErrorType)
}