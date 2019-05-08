package com.ardi.infusmonitoring.Entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
        @SerializedName("nip_user")
        val nipUser: String? = null,
        @SerializedName("username")
        val username: String? = null,
        @SerializedName("nama_user")
        val namaUser: String? = null,
        @SerializedName("email")
        val emailUser: String? = null,
        @SerializedName("alamat")
        val alamatUser: String? = null,
        @SerializedName("tanggal_lahir")
        val tanggalLahir: String? = null,
        @SerializedName("tanggal_masuk")
        val tanggalMasuk: String? = null,
        @SerializedName("foto")
        val fotoUser: String? = null,
        @SerializedName("jabatan")
        val jabatanUser: String? = null,
        @SerializedName("jenis_kelamin")
        val jenisKelamin: String? = null,
        @SerializedName("password")
        val passwordUser: String? = null
) : Serializable