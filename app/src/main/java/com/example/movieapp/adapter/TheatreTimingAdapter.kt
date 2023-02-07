package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.Constants

class TheatreTimingAdapter(arrayList: ArrayList<String>, theatre_name : String, mcontext: Context) :
    RecyclerView.Adapter<TheatreTimingAdapter.RecyclerViewHolder>() {

    private val theatreTimingModelList: ArrayList<String>
    private val mcontext: Context
    private val theatre_name : String

    init {
        theatreTimingModelList = arrayList
        this.mcontext = mcontext
        this.theatre_name = theatre_name
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

        holder.theatreTiming.setOnClickListener {
            holder.onCLick()
        }
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val theatreTiming: TextView = itemView.findViewById(R.id.theatre_timing)

        fun onCLick() {
            Constants.timing = theatreTiming.text.toString()
            Constants.theatre_name = theatre_name
            itemView.findNavController().navigate(R.id.action_theatreSelection_to_seatsSelection)
        }
    }
}