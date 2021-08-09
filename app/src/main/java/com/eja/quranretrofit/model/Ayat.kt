package com.eja.quranretrofit.model

import com.google.gson.annotations.SerializedName

data class Ayat(
    @SerializedName("number")
    var numberAyat: Int,
    @SerializedName("text")
    var text: String,
    @SerializedName("numberInSurah")
    var numberInSurah: String,
    @SerializedName("juz")
    var juz: Int
)
