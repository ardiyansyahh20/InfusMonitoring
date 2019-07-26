package com.ardi.infusmonitoring.ApiRepository

import android.util.Log
import com.ardi.infusmonitoring.BuildConfig

object UserApi {
    fun getUser(): String {
        val Url = BuildConfig.BASE_URL + "user.php"
        Log.d("data", Url)
        return Url
    }
    fun setInfuse(tpm : String,ft:String,waktu:String,ml:String): String {
        val Url = BuildConfig.BASE_URL + "setInfuse.php?tpm=$tpm&waktu=$waktu&ft=$ft&ml=$ml"
        Log.d("data", Url)
        return Url
    }
    fun getInfuse(): String {
        val Url = BuildConfig.BASE_URL + "infus.php?"
        Log.d("data", Url)
        return Url
    }
}