package com.eja.quranretrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("surahs")
    var surahs: List<Surah>,
    var ayats: List<Ayat>,
    var edition: Edition
)
