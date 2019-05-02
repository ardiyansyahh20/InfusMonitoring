package com.ardi.infusmonitoring.Activity

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.Window
import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.Entity.User
import com.ardi.infusmonitoring.Interface.UserView
import com.ardi.infusmonitoring.Item.MD5
import com.ardi.infusmonitoring.Item.SharedPreference
import com.ardi.infusmonitoring.MainActivity
import com.ardi.infusmonitoring.Presenter.UserPresenter
import com.ardi.infusmonitoring.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), UserView {
    lateinit var nip: String
    lateinit var pass: String
    var ada: Boolean = true
    override fun showData(listUser: List<User>) {

        for (i in listUser.indices) {

            val user: User = listUser[i]
            println(user.passwordUser)


            if (user.nipUser == nip) {
                ada = false

                pass = edt_password_login.text.toString()
                println(pass)

                //password
                if (user.passwordUser == pass) {
                    println("USER: ${user.nipUser}")
                    startActivity<MainActivity>()
                    this.finish()

                } else if (user.passwordUser != pass) {
                    tv_pesan_login.text = "Password Salah"
                    tv_pesan_login.visibility = View.VISIBLE
                }
            }

        }
//        if (ada) {
//            tv_pesan_login.setText("Nomor tidak terdaftar ")
//            tv_pesan_login.visibility = View.VISIBLE
//        }
        progressBar.visibility = View.GONE
    }

    internal lateinit var window: Window
    lateinit var presenter: UserPresenter
    lateinit var gson: Gson
    lateinit var apiRepository: ApiRepository
    lateinit var pref: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        pref = SharedPreference(this)
        val loading = progressBar

        nip = String()
        pass = String()
        loading.visibility = View.INVISIBLE
        gson = Gson()
        apiRepository = ApiRepository()
        presenter = UserPresenter(apiRepository, gson, this)

        presenter.ambilDataUser()
        btn_login.setOnClickListener {
            loading.visibility = View.VISIBLE
            nip = edt_nip_login.text.toString()
            if (edt_nip_login.text.isNullOrBlank()) {
                edt_nip_login.setError("Tidak Boleh Kosong")
            }
            if (edt_password_login.text.isNullOrBlank()) {
                edt_password_login.setError("Tidak Boleh Kosong")
            } else {
                nip = edt_nip_login.text.toString()
                pass = edt_password_login.text.toString()
                presenter.ambilDataUser()
            }
        }
    }


}
