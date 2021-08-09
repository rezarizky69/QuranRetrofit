package com.eja.quranretrofit.model

import com.google.gson.annotations.SerializedName


data class Edition(

    @SerializedName("identifier")
    var identifier: String,

    @SerializedName("language")
    var lang: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("englishName")
    var englishName: String,

    @SerializedName("format")
    var format: String,

    @SerializedName("type")
    var type: String

)
