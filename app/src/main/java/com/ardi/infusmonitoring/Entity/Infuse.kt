package com.ardi.infusmonitoring.Entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Infuse(

        @SerializedName("id")
        val id: String? = null,
        @SerializedName("tpm")
        val tpm: String? = null,
        @SerializedName("stated")
        val stated: String? = null,
        @SerializedName("ft")
        val ft: String? = null,
        @SerializedName("waktu")
        val waktu: String? = null,
        @SerializedName("ml")
        val ml: String? = null


) : Serializable