package com.marrapps.handz.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.FirebaseApp
import com.marrapps.handz.BaseActivity
import com.marrapps.handz.R
import com.marrapps.handz.hands.HandsActivity
import com.marrapps.handz.model.numbers.NumbersResponse
import com.marrapps.handz.model.retrofit.Repository
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), SplashContract.View {

    private lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        FirebaseApp.initializeApp(applicationContext)

        val repository = Repository(this)
        presenter = SplashPresenter(repository, this)

        pbSplashLoading.visibility = View.VISIBLE
        presenter.fetchNumbers()
    }

    override fun onNumbersResponse(numbersResponse: NumbersResponse) {
        val intent = Intent(this, HandsActivity::class.java).apply {
            putExtra("numbers", numbersResponse)
        }
        startActivity(intent)
        finish()
    }

    private fun onRetry() {
        pbSplashLoading.visibility = View.VISIBLE
        presenter.fetchNumbers()
    }

    override fun onApiError() {
        pbSplashLoading.visibility = View.INVISIBLE
        showErrorDialog(
            "Não foi possível carregar as informações. Por favor, tente novamente mais tarde."
        ) { onRetry() }
    }

    override fun onConnectionError() {
        pbSplashLoading.visibility = View.INVISIBLE
        showErrorDialog(
            "Não foi possível conectar. Por favor, verifique sua conexão com a internet."
        ) { onRetry() }
    }
}
