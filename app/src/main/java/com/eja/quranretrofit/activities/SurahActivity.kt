package com.eja.quranretrofit.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eja.quranretrofit.R
import com.eja.quranretrofit.adapter.AyatAdapter
import com.eja.quranretrofit.model.Ayat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SurahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_content)

        val mToolbarSurah: Toolbar = findViewById(R.id.mToolbarSurah)
        setSupportActionBar(mToolbarSurah)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val json = intent.getStringExtra("jsonlist")
        val jsonIndo = intent.getStringExtra("jsonlistIndo")
        val jsonTitle = intent.getStringExtra("jsonTitle")
        val type = object : TypeToken<List<Ayat?>?>() {}.type

        val txtTitleSurah = findViewById<TextView>(R.id.txtTitleSurah)
        txtTitleSurah.text = jsonTitle
        txtTitleSurah.findViewById<View>(R.id.txtTitleSurah)
        txtTitleSurah.text = jsonTitle

        val gson = Gson()
        val ayatList: List<Ayat> = gson.fromJson(json, type)
        val ayatListIndo: List<Ayat> = gson.fromJson(jsonIndo, type)

        val recyclerAyat = findViewById<RecyclerView>(R.id.ayat_list)
        val layoutManager = LinearLayoutManager(this)
        val ayatAdapter = AyatAdapter(this, ayatList, ayatListIndo)
        recyclerAyat.layoutManager = layoutManager
        recyclerAyat.setHasFixedSize(true)
        recyclerAyat.adapter = ayatAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (item.itemId === android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}