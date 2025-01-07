package com.example.juegos

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class BackgroundSettingsAdapter(
    private val imageViews : List<Int>,
    private val texts : List<String>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<BackgroundSettingsAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var text: TextView = itemView.findViewById(R.id.textoFondo)
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int
    ): BackgroundSettingsAdapter.CardViewHolder {

        val view = LayoutInflater.from(view.context).inflate(R.layout.card, view, false)
        return CardViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.imageView.setImageResource(imageViews[position])
        holder.text.text = texts[position]

        holder.itemView.setOnClickListener {
            onItemClick(imageViews[position])


        }

    }

    override fun getItemCount(): Int {
        return imageViews.size
    }


}

