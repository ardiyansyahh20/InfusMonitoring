package com.ardi.infusmonitoring.Presenter

import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.ApiRepository.UserApi
import com.ardi.infusmonitoring.Entity.UserResponse
import com.ardi.infusmonitoring.Interface.UserView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class UserPresenter(val api: ApiRepository, val gson: Gson, val view: UserView) {
    fun ambilDataUser() {
        doAsync {
            val data = gson.fromJson(api.doRequest(UserApi.getUser()), UserResponse::class.java)
            uiThread {
                view.showData(data.data)
            }
        }
    }
}