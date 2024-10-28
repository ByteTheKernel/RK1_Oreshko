package com.example.rk_1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.text_1)
    val image = view.findViewById<ImageView>(R.id.imageView)

    fun bind(number: Int) {
        text.text = "$number"

        if(number % 2 == 0) {
            image.setBackgroundColor(ContextCompat.getColor(image.context, R.color.red))
        } else {
            image.setBackgroundColor(ContextCompat.getColor(image.context, R.color.blue))
        }
    }
}