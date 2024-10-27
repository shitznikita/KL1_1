package com.example.firstproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val text = view.findViewById<TextView>(R.id.text1)
    private val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
        if (number % 2 == 0) {
            image.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.red))
        } else {
            image.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.blue))
        }
    }

}