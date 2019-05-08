package com.ardi.infusmonitoring.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ardi.infusmonitoring.Entity.User
import com.ardi.infusmonitoring.Interface.UserView
import com.ardi.infusmonitoring.Item.SharedPreference
import com.ardi.infusmonitoring.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.io.Serializable

class MainActivity : AppCompatActivity(){

    lateinit var user: User
    lateinit var pref: SharedPreference
    var nama: String? = ""
    var nip: String? = ""
    var pass: String? = ""
    var foto: String? = ""
    var alamat: String? = ""
    var jabatan: String? = ""
    var email: String? = ""
    var jenisKelamin: String? = ""
    var tanggalLahir: String? = ""
    var tanggalMasuk: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = SharedPreference(this)
        user= User(null, null, null, null, null,
                null, null, null, null, null)
        if (pref.getValueString("NIP").isNullOrEmpty()) {
            user = intent.getSerializableExtra("data") as User
            pref.save("NIP", user.nipUser.toString())
            pref.save("PASS", user.passwordUser.toString())
            pref.save("NAMA", user.namaUser.toString())
            pref.save("FOTO", user.fotoUser.toString())
            pref.save("ALAMAT", user.alamatUser.toString())
            pref.save("JABATAN", user.jabatanUser.toString())
            pref.save("EMAIL", user.emailUser.toString())
            pref.save("TANGGALLAHIR", user.tanggalLahir.toString())
            pref.save("TANGGALMASUK", user.tanggalMasuk.toString())
            pref.save("JENISKELAMIN", user.jenisKelamin.toString())
            tv_nama_menu_utama.text = user.namaUser
        }
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



        println("data user nama : $nama")
        println("nim user : $nip")

        tv_nama_menu_utama.text = nama
        btn_logout.setOnClickListener {
            pref.clearSharedPreference()
            startActivity<LoginActivity>()
            this.finish()
        }

        btn_profil.setOnClickListener {
            startActivity<DetailUserActivity>("user" to user)
        }

    }
}
