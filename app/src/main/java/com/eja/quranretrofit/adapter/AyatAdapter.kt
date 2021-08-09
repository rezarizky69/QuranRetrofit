package com.eja.quranretrofit.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eja.quranretrofit.R
import com.eja.quranretrofit.activities.SurahActivity
import com.eja.quranretrofit.model.Ayat
import com.eja.quranretrofit.model.Surah
import com.google.gson.Gson

class AyatAdapter(
    private var context: Context,
    private var list: List<Ayat>,
    private var listIndo: List<Ayat>
) : RecyclerView.Adapter<AyatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_ayat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ayat: Ayat = list[position]
        val ayatIndo: Ayat = listIndo[position]
        holder.nomorAyat.text = ayat.numberInSurah
        holder.arabic.text = ayat.text
        holder.tarjim.text = ayatIndo.text

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nomorAyat: TextView
        var arabic: TextView
        var tarjim: TextView

        init {
            nomorAyat = itemView.findViewById(R.id.number_ayat)
            arabic = itemView.findViewById(R.id.arabic)
            tarjim = itemView.findViewById(R.id.tarjim)
        }
    }
}