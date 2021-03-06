package com.example.display1000int

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var numbers: ArrayList<NumberModel>

    fun setNumbers(numberList: ArrayList<NumberModel>) {
        numbers = numberList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.random_int_view, parent, false)
        val tv = v.findViewById<TextView>(R.id.test_tv)
        return ViewHolder(v, tv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = String.format("Setting textview for position: %s", position)
        Log.i("CustomAdapter", message)
        holder.textView.text = numbers.get(position).value.toString()
    }

    override fun getItemCount(): Int {
        Log.i("CustomAdapter", String.format("Getting item count: %s", numbers.size))
        return numbers.size
    }

    class ViewHolder(frameLayout: View?, // each data item is just a string in this case
                     val textView: TextView) : RecyclerView.ViewHolder(frameLayout!!)

}