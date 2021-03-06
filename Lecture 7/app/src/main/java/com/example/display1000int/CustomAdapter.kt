package com.example.display1000int

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CustomAdapter(private val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imageView: ImageView = v.findViewById(R.id.my_image_view);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cell_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val urlToCall = String.format("https://picsum.photos/500/500?image=%d", position)
        Glide.with(context).clear(holder.imageView)
        Glide.with(context).load(urlToCall).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return 50
    }
}