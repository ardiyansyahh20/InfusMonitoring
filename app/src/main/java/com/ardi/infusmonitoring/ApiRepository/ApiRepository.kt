package com.ardi.infusmonitoring.ApiRepository

import java.net.URL

class ApiRepository {
    fun doRequest(url: String):String{
        val data = URL(url).readText()

        return data
    }
}