package com.ardi.infusmonitoring.Item

import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.Entity.Infuse
import com.ardi.infusmonitoring.Entity.Status
import com.ardi.infusmonitoring.Interface.InfuseView
import com.ardi.infusmonitoring.Presenter.InfusePresenter
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import com.google.gson.Gson

class JobService : JobService(),InfuseView{
    override fun onStopJob(job: JobParameters?): Boolean {
return true
    }

    override fun onStartJob(job: JobParameters?): Boolean {
        print("on start job \n")
        cekStateInfuse(job)
        return true    }

    override fun setDataInfuse(list: List<Status>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataInfuse(list: List<Infuse>) {
        print("show data \n")

            val penjualan = list[0]

            if (penjualan.stated.equals("kosong")) {
                    notifikasi = Notifikasi()
                    print("infuse kosong \n")
                penjualan.waktu?.let { notifikasi.notif(this, "Warning", "Infuse telah kosong", it, 1) }

                }

        }


    lateinit var gson: Gson
    lateinit var apiReposirtory: ApiRepository
    lateinit var presenter: InfusePresenter
    lateinit var sharedPreferences: SharedPreference
    lateinit var notifikasi: Notifikasi



    fun cekStateInfuse(job: JobParameters?) {
        print("cek State infuse \n")
        gson = Gson()
        apiReposirtory = ApiRepository()
        presenter = InfusePresenter(apiReposirtory, gson, this)
        presenter.getDataInfuse()
        jobFinished(job!!, true)
    }
}