package com.example.apidatabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
 data class Kontak (
     val id: Int,
     val nama: String,
     @SerialName(value = "email")
     val alamat: String,
     @SerialName(value = "telpon")
     val noHp: String,

     )


