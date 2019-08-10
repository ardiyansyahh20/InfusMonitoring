package com.ardi.infusmonitoring.Item


import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.Entity.Infuse
import com.ardi.infusmonitoring.Entity.Status
import com.ardi.infusmonitoring.Interface.InfuseView
import com.ardi.infusmonitoring.Presenter.InfusePresenter
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import com.google.gson.Gson

class MyJobService : JobService(),InfuseView {

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

        val infuse = list[0]
//pengecekan data isi infus jika infus kosong maka akan ada notifikasi kepada perawat dan akan di ulang selama belum di response
        if (infuse.stated.equals("0")) {
            notifikasi = Notifikasi()
            print("infuse kosong \n")
            infuse.id?.let { notifikasi.notif(this, "Warning", "Infus telah kosong", it, 1) }

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
