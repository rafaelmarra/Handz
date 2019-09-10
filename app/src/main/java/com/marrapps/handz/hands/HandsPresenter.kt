package com.marrapps.handz.hands

import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.marrapps.handz.model.numbers.NumbersResponse

class HandsPresenter(private val view: HandsContract.View) : HandsContract.Presenter {

    private val handsStorage =
        FirebaseStorage.getInstance().reference.child("hands")

    private var successCounter = 0

    override fun fetchImages(numbersResponse: NumbersResponse) {

        val numbersList = numbersResponse.numbers
        val urlList = mutableListOf("", "", "", "", "")

        numbersList.forEachIndexed { index, it ->
            val path = handsStorage.child("hand$it.png")

            path.downloadUrl
                .addOnSuccessListener { uri ->
                    urlList[index] = uri.toString()
                    successCounter++
                    if (successCounter == numbersList.size) {
                        view.fetchComplete(urlList)
                    }
                }.addOnFailureListener { e ->
                    Log.e("IMAGE REQUEST", e.message ?: "undefined error")
                    view.onError()
                }
        }
    }
}