package com.marrapps.handz.mvvm.other

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.marrapps.handz.BaseActivity
import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.NumbersServiceListener
import com.marrapps.handz.model.retrofit.Repository
import com.marrapps.handz.mvvm.ViewModelFactory

class OtherViewModel(private val repository: Repository): ViewModel(), NumbersServiceListener {

    sealed class Command {
        class StartBrowser(val url: String) : Command()
        class SetLoading(val loading: Boolean) : Command()
        class ShowError(val message: String?) : Command()
        object RequestCameraPermission : Command()
        object RequestLocationPermission : Command()
    }

    val command = MutableLiveData<Command>()

    fun getNumbers(){
        repository.getNumbers(this)
        command.value = Command.SetLoading(true)
    }

    override fun onSuccess(response: NumbersResponse) {
        getNumbers()
    }

    override fun onError(error: Repository.ErrorType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class OtherActivity: BaseActivity(){

    private val viewModel = ViewModelProviders
        .of(this, ViewModelFactory(this))
        .get(OtherViewModel::class.java)


    private fun initObservers(){
        viewModel.command.observe(this, Observer {
            when (it) {
                is OtherViewModel.Command.StartBrowser -> startWebView(it.url)
                is OtherViewModel.Command.SetLoading -> showLoading(it.loading)
                is OtherViewModel.Command.ShowError -> showError(it.message)
                is OtherViewModel.Command.RequestCameraPermission -> requestCameraPermission()
                is OtherViewModel.Command.RequestLocationPermission -> requestLocationPermission()
            }
        })
    }

    private fun startWebView(url: String){}
    private fun showLoading(loading: Boolean){}
    private fun showError(message: String?){}
    private fun requestCameraPermission(){}
    private fun requestLocationPermission(){}

    fun qiudhqw(){
        initObservers()
        viewModel.getNumbers()
    }
}