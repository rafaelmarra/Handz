package com.marrapps.handz.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


fun Context.isConnected(): Boolean {

    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

    return networkInfo?.isConnected == true
}