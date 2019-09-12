package com.marrapps.handz.hands

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.marrapps.handz.BaseActivity
import com.marrapps.handz.R
import com.marrapps.handz.model.numbers.NumbersResponse
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*

class HandsActivity : BaseActivity(), HandsContract.View {

    private lateinit var presenter: HandsContract.Presenter
    private lateinit var numbersResponse: NumbersResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        setupRecyclerView()

        numbersResponse = intent.extras?.getSerializable("numbers") as NumbersResponse

        presenter = HandsPresenter(this)
        presenter.fetchImages(numbersResponse)
    }

    private fun setupRecyclerView() {
        rvHandsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HandsActivity)
            adapter = HandsRecyclerAdapter(emptyList())
            setHasFixedSize(true)
        }
    }

    override fun fetchComplete(urlList: List<String>) {
        rvHandsList.adapter = HandsRecyclerAdapter(urlList)
        pbListLoading.visibility = View.GONE
        rvHandsList.visibility = View.VISIBLE
    }

    override fun onError() {
        showErrorDialog(
            "Não foi possível carregar as informações. Por favor, tente novamente mais tarde."
        ) { presenter.fetchImages(numbersResponse) }
    }
}
