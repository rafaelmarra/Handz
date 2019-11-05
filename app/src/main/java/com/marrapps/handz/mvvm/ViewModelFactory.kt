package com.marrapps.handz.mvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marrapps.handz.model.retrofit.Repository
import com.marrapps.handz.mvvm.other.AnotherViewModel
import com.marrapps.handz.mvvm.other.OtherViewModel

class ViewModelFactory(context: Context) : ViewModelProvider.NewInstanceFactory() {

    private val repository = Repository(context)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(NumberListViewModel::class.java) ->
                    NumberListViewModel(repository)

                isAssignableFrom(OtherViewModel::class.java) ->
                    OtherViewModel(repository)

                isAssignableFrom(AnotherViewModel::class.java) ->
                    AnotherViewModel(repository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}