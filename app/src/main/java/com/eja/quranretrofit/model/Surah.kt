package com.eja.quranretrofit.model

import com.google.gson.annotations.SerializedName

data class Surah(
    @SerializedName("name")
    var name: String,
    @SerializedName("number")
    var number: String,
    @SerializedName("englishName")
    var englishName: String,
    @SerializedName("englishNameTranslation")
    var translateName: String,
    @SerializedName("revelationType")
    var type: String,
    @SerializedName("ayahs")
    var ayatList: List<Ayat>
)
