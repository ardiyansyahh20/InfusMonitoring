package com.ardi.infusmonitoring.Presenter

import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.ApiRepository.UserApi
import com.ardi.infusmonitoring.Entity.InfuseResponse
import com.ardi.infusmonitoring.Entity.StatusResponse
import com.ardi.infusmonitoring.Interface.InfuseView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class InfusePresenter (val apiRepository: ApiRepository, val gson: Gson, val infuseView: InfuseView){
    fun getDataInfuse(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(UserApi.getInfuse()),InfuseResponse::class.java)
        uiThread {
            infuseView.getDataInfuse(data.data)
        } }
    }
    fun setDataInfuse(tpm: String,waktu:String,ml:String,ft:String){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(UserApi.setInfuse(tpm,ft,waktu,ml)),StatusResponse::class.java)
            uiThread {
                infuseView.setDataInfuse(data.data)
            } }
    }
}