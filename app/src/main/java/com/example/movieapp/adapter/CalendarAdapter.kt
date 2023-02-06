package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.model.CalendarModel

class CalendarAdapter (arrayList: ArrayList<CalendarModel>, mcontext: Context) :
    RecyclerView.Adapter<CalendarAdapter.RecyclerViewHolder>() {

    private val calendarModelList: ArrayList<CalendarModel>
    private val mcontext: Context

    init {
        calendarModelList = arrayList
        this.mcontext = mcontext
        Constants.date = calendarModelList[0].date + " " + calendarModelList[0].month
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_calendar_view, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return calendarModelList.size
    }

    var row_index = 0
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerData: CalendarModel = calendarModelList[position]
        holder.day.text = recyclerData.day
        holder.date.text = recyclerData.date
        holder.month.text = recyclerData.month

        holder.calendarLinearLayout.setOnClickListener{
            row_index = position
            Constants.date = calendarModelList[position].date + " " + calendarModelList[position].month
            notifyDataSetChanged()
        }

        if(row_index == position) {
            holder.calendarLinearLayout.setBackgroundColor(mcontext.getColor(R.color.yellow))
            holder.day.setTextColor(mcontext.getColor(R.color.white))
            holder.date.setTextColor(mcontext.getColor(R.color.white))
            holder.month.setTextColor(mcontext.getColor(R.color.white))
        }
        else {
            holder.calendarLinearLayout.setBackgroundColor(mcontext.getColor(R.color.white))
            holder.day.setTextColor(mcontext.getColor(R.color.black))
            holder.date.setTextColor(mcontext.getColor(R.color.black))
            holder.month.setTextColor(mcontext.getColor(R.color.black))
        }
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.calendar_day)
        val date: TextView = itemView.findViewById(R.id.calendar_date)
        val month: TextView = itemView.findViewById(R.id.calendar_month)
        val calendarLinearLayout : LinearLayout = itemView.findViewById(R.id.calendar_linear_layout)
    }

}