package com.ardi.infusmonitoring.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import com.ardi.infusmonitoring.Entity.User
import com.ardi.infusmonitoring.Item.SharedPreference

import com.ardi.infusmonitoring.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var pref: SharedPreference
    var nama: String? = ""
    var nip: String? = ""
    var pass: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = SharedPreference(this)

        if (pref.getValueString("NIP").isNullOrEmpty()) {
            val user = intent.getSerializableExtra("data") as User

            pref.save("NIP", user.nipUser.toString())
            pref.save("PASS", user.passwordUser.toString())
            pref.save("NAMA", user.namaUser.toString())
            tv_nama_menu_utama.text = user.namaUser
        } else {
            nama = pref.getValueString("NAMA")
            pass = pref.getValueString("PASS")
            nip = pref.getValueString("NIP")
        }


        println("data user nama : $nama")
        println("nim user : $nip")

        tv_nama_menu_utama.text = nama

    }

}
