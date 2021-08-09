package com.eja.quranretrofit.api

import com.eja.quranretrofit.model.Cek
import com.eja.quranretrofit.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("quran/id.indonesian")
    fun getData() : Call<Data>

    @GET("quran/quran-uthmani")
    fun getDataArabic() : Call<Cek>

    @GET("quran/{lang}")
    fun getCek(@Path("lang") lang: String) : Call<Cek>

    @GET("surah/1/id.indonesian")
    fun getSurahTranslation() : Call<Cek>
}