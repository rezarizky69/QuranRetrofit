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
import com.eja.quranretrofit.model.Surah
import com.google.gson.Gson


class SurahAdapter(
    private var context: Context,
    private var list: List<Surah>,
    private var listIndo: List<Surah>
) : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {

     lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val surah: Surah = list[position]
        val surahIndo: Surah = listIndo[position]

        holder.numberSurah.text = surah.number
        holder.titleSurah.text = surah.name
        holder.translationTitle.text = surah.englishName
        holder.typeTitle.text = surah.type
        holder.ayatSize.text = surah.ayatList.size.toString() + " ayat"
        view.setOnClickListener {
            val gson = Gson()
            val json = gson.toJson(surah.ayatList)
            val jsonIndo = gson.toJson(surahIndo.ayatList)
            val intent = Intent(context, SurahActivity::class.java)
            intent.putExtra("jsonlist", json)
            intent.putExtra("jsonlistIndo", jsonIndo)
            intent.putExtra("jsonTitle", surah.englishName)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var numberSurah: TextView
        var titleSurah: TextView
        var translationTitle: TextView
        var typeTitle: TextView
        var ayatSize: TextView

        init {
            numberSurah = itemView.findViewById(R.id.number_surah)
            titleSurah = itemView.findViewById(R.id.title_surah)
            translationTitle = itemView.findViewById(R.id.translation_title)
            typeTitle = itemView.findViewById(R.id.type_surah)
            ayatSize = itemView.findViewById(R.id.ayat_size)
        }
    }
}