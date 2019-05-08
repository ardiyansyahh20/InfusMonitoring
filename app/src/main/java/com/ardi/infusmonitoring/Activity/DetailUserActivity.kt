package com.ardi.infusmonitoring.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ardi.infusmonitoring.Item.SharedPreference
import com.ardi.infusmonitoring.Item.getStringDate
import com.ardi.infusmonitoring.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {
    lateinit var pref: SharedPreference
    var nama: String? = ""
    var nip: String? = ""
    var pass: String? = ""
    var foto: String? = ""
    var alamat: String? = ""
    var jabatan: String? = ""
    var email: String? = ""
    var tanggalLahir: String? = ""
    var tanggalMasuk: String? = ""
    var jenisKelamin: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        pref = SharedPreference(this)


        nip = pref.getValueString("NIP")
        nama = pref.getValueString("NAMA")
        pass = pref.getValueString("PASS")
        foto = pref.getValueString("FOTO")
        alamat = pref.getValueString("ALAMAT")
        jabatan = pref.getValueString("JABATAN")
        email = pref.getValueString("EMAIL")
        tanggalLahir = pref.getValueString("TANGGALLAHIR")
        tanggalMasuk = pref.getValueString("TANGGALMASUK")
        jenisKelamin = pref.getValueString("JENISKELAMIN")



        Picasso.get().load(foto).into(img_user)
        tv_nip_user_detail.text = nip
        tv_nama_user_detail.text = nama
        tv_alamat_user_detail.text = alamat
        tv_jabatan_user_detail.text = jabatan
        tv_tanggal_lahir_user_detail.text = tanggalLahir?.let { getStringDate(it) } ?: "-"
        tv_tanggal_masuk_user_detail.text = tanggalMasuk?.let { getStringDate(it) } ?: "-"
        tv_email_user_detail.text = email
        tv_jenis_kelamin_user_detail.text = jenisKelamin

    }
}
