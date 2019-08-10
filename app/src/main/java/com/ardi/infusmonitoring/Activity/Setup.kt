package com.ardi.infusmonitoring.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.Entity.Infuse
import com.ardi.infusmonitoring.Entity.Status
import com.ardi.infusmonitoring.Interface.InfuseView
import com.ardi.infusmonitoring.Presenter.InfusePresenter
import com.ardi.infusmonitoring.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_setup.*
import kotlinx.android.synthetic.main.item_setup.edt_jumlah_ml
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Setup : AppCompatActivity(),InfuseView {
    override fun setDataInfuse(list: List<Status>) {
        if (list[0].kode.equals("1")) {
            startActivity<MainActivity>()
            toast("${list[0].pesan}")
            finish()
        }



    }

    override fun getDataInfuse(list: List<Infuse>) {
        infuse = list[0]
        if(!infuse.tpm.isNullOrEmpty()){
            edt_faktor_tetes.setText(infuse.ft)
            edt_jumlah_ml.setText(infuse.ml)
            edt_waktu.setText(infuse.waktu)
        }
    }


    lateinit var apiRepository: ApiRepository
    lateinit var gson: Gson
    lateinit var presenter:InfusePresenter
    lateinit var infuse: Infuse



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_setup)
        gson = Gson()
        apiRepository = ApiRepository()
        presenter = InfusePresenter(apiRepository,gson,this)
        presenter.getDataInfuse()






btnHitung.setOnClickListener {
    var ft = edt_faktor_tetes.text.toString()
    var ml = edt_jumlah_ml.text.toString()
    var jam = edt_waktu.text.toString()
    var ftInt : Int = ft.toInt()
    var mlInt : Int = ml.toInt()
    var jamInt : Int = jam.toInt()

    //rumus infus TPM = (jumlah cairan X faktor tetes) / jam(hitungan menit)
    val JTPM = (mlInt * ftInt) / (jamInt)

    presenter.setDataInfuse(JTPM.toString(),jam,ml,ft)
}

    }
}
