package com.example.movieapp.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R

class TheatreTimingAdapter(arrayList: ArrayList<String>, mcontext: Context) :
    RecyclerView.Adapter<TheatreTimingAdapter.RecyclerViewHolder>() {

    private val theatreTimingModelList: ArrayList<String>
    private val mcontext: Context

    init {
        theatreTimingModelList = arrayList
        this.mcontext = mcontext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_theatre_time_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return theatreTimingModelList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.theatreTiming.text = theatreTimingModelList[position]
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val theatreTiming: TextView = itemView.findViewById(R.id.theatre_timing)
    }
}