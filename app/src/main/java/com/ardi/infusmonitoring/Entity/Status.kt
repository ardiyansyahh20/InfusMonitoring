package com.ardi.infusmonitoring.Entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Status(
        @SerializedName("kode")
        val kode: String? = null,
        @SerializedName("pesan")
        val pesan :String? = null
):Serializable