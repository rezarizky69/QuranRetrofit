package com.eja.quranretrofit.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eja.quranretrofit.R
import com.eja.quranretrofit.adapter.SurahAdapter
import com.eja.quranretrofit.api.ApiClient
import com.eja.quranretrofit.api.ApiInterface
import com.eja.quranretrofit.model.Cek
import com.eja.quranretrofit.model.Data
import com.eja.quranretrofit.model.Surah
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val arabic: String = "quran-uthmani"
    private val indo: String = "id.indonesian"

    private var surahsArabic: List<Surah> = ArrayList()
    private var surahsIndo: List<Surah> = ArrayList()

    var loadingData: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingData = ProgressDialog(this)
        loadingData!!.setTitle("Mohon Tunggu..")
        loadingData!!.setCancelable(false)
        loadingData!!.setMessage("Sedang mengambil data")

        val recyclerSurah: RecyclerView = findViewById(R.id.surah_list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerSurah.setHasFixedSize(true)
        recyclerSurah.layoutManager = linearLayoutManager

        val apiInterface: ApiInterface = ApiClient.getRetrofit()!!.create(ApiInterface::class.java)

        val call: Call<Cek> = apiInterface.getCek(arabic)
        val callIndo: Call<Cek> = apiInterface.getCek(indo)

        getDataListArabic(recyclerSurah, call)
        getDataTarjim(callIndo)

    }

    fun getDataTarjim(callIndo: Call<Cek>) {
        callIndo.enqueue(object : Callback<Cek?> {
            override fun onResponse(call: Call<Cek?>?, response: Response<Cek?>) {
                val data: Data = response.body()!!.data
                surahsIndo = data.surahs
            }

            override fun onFailure(call: Call<Cek?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "gagal", Toast.LENGTH_SHORT).show()
                Log.d("error", t.message)
            }
        })
    }

    fun getDataListArabic(recyclerSurah: RecyclerView, call: Call<Cek>) {
        loadingData!!.show()
        call.enqueue(object : Callback<Cek?> {
            override fun onResponse(call: Call<Cek?>, response: Response<Cek?>) {
                val data: Data = response.body()!!.data
                surahsArabic = data.surahs

                val surahAdapter = SurahAdapter(this@MainActivity, surahsArabic, surahsIndo)
                recyclerSurah.adapter = surahAdapter
                loadingData!!.dismiss()
            }

            override fun onFailure(call: Call<Cek?>, t: Throwable) {
                loadingData!!.dismiss()
                Toast.makeText(this@MainActivity, "gagal", Toast.LENGTH_SHORT).show();
                Log.d("error", t.message);
            }
        })
    }
}