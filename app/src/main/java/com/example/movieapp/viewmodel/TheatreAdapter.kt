package com.example.movieapp.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.Theatre_P

class TheatreAdapter(arrayList: ArrayList<Theatre_P>, mcontext: Context) :
    RecyclerView.Adapter<TheatreAdapter.RecyclerViewHolder>() {

    private val theatreModelList: ArrayList<Theatre_P>
    private val mcontext: Context

    init {
        theatreModelList = arrayList
        this.mcontext = mcontext
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TheatreAdapter.RecyclerViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_theatre_layout, parent, false)
        return RecyclerViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerData: Theatre_P = theatreModelList[position]

        holder.name.text = recyclerData.name

        val theatreTimingAdapter : TheatreTimingAdapter = TheatreTimingAdapter(recyclerData.timing, mcontext)

        val theatreTimingLayoutManager = GridLayoutManager(mcontext, 3)

        holder.recyclerViewTiming.layoutManager = theatreTimingLayoutManager
        holder.recyclerViewTiming.adapter = theatreTimingAdapter
    }

    override fun getItemCount(): Int {
        return theatreModelList.size
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.theatre_name)
        val recyclerViewTiming : RecyclerView = itemView.findViewById(R.id.theatre_timings_recycler_view)
    }
}