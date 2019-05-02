package com.ardi.infusmonitoring.ApiRepository

import android.util.Log
import com.ardi.infusmonitoring.BuildConfig

object UserApi {
    fun getUser(): String {
        val Url = BuildConfig.BASE_URL + "user.php"
        Log.d("data", Url)
        return Url
    }
}