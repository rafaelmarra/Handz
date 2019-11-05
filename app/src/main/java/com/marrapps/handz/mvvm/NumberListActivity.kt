package com.marrapps.handz.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marrapps.handz.R
import com.marrapps.handz.model.retrofit.Repository
import kotlinx.android.synthetic.main.activity_number_list.*

class NumberListActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders
            .of(this, ViewModelFactory(this))
            .get(NumberListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_list)
        setList()
        setObservers()

        viewModel.getNumbers()
    }

    private fun setList() {
        rvNumbersList.apply {
            layoutManager = LinearLayoutManager(this@NumberListActivity)
            adapter = NumbersListAdapter(emptyList())
            setHasFixedSize(true)
        }
    }

    private fun setObservers() {
        viewModel.numberList.observe(this, Observer {
            rvNumbersList.adapter = NumbersListAdapter(it)
        })

        viewModel.numberError.observe(this, Observer {
            val message = when (it) {
                Repository.ErrorType.API_ERROR ->
                    "Não foi possível carregar as informações. Por favor, tente novamente mais tarde."

                Repository.ErrorType.CONNECTION_ERROR ->
                    "Não foi possível conectar. Por favor, verifique sua conexão com a internet."
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }
}
