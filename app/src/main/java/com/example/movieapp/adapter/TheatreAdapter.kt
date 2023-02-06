package com.example.movieapp.viewmodel

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.CustomHomeScreenRecyclerViewLayoutBinding
import com.example.movieapp.databinding.CustomTheatreLayoutBinding
import com.example.movieapp.model.Theatre_P
import com.example.movieapp.viewmodel.TheatreAdapter.*
import androidx.recyclerview.widget.ListAdapter as ListAdapter

//class TheatreAdapter(arrayList: ArrayList<Theatre_P>, mcontext: Context) :
//    RecyclerView.Adapter<TheatreAdapter.RecyclerViewHolder>() {
//
//    private val theatreModelList: ArrayList<Theatre_P>
//    private val mcontext: Context
//
//    init {
//        theatreModelList = arrayList
//        this.mcontext = mcontext
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): TheatreAdapter.RecyclerViewHolder {
//
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.custom_theatre_layout, parent, false)
//        return RecyclerViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//        val recyclerData: Theatre_P = theatreModelList[position]
//
//        holder.name.text = recyclerData.name
//
//        val theatreTimingAdapter : TheatreTimingAdapter = TheatreTimingAdapter(recyclerData.timing,
//            holder.name.text.toString(), mcontext)
//
//        val theatreTimingLayoutManager = GridLayoutManager(mcontext, 3)
//
//        holder.recyclerViewTiming.layoutManager = theatreTimingLayoutManager
//        holder.recyclerViewTiming.adapter = theatreTimingAdapter
//    }
//
//    override fun getItemCount(): Int {
//        return theatreModelList.size
//    }
//
//    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val name: TextView = itemView.findViewById(R.id.theatre_name)
//        val recyclerViewTiming : RecyclerView = itemView.findViewById(R.id.theatre_timings_recycler_view)
//    }
//}

class TheatreAdapter():
    ListAdapter<Theatre_P, TheatreViewHolder>(ComparatorDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheatreViewHolder {
        Log.d("Application", "Inside List Adapter")
        val binding = CustomTheatreLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TheatreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TheatreViewHolder, position: Int) {
        val note = getItem(position)
        note?.let {
            holder.bind(it)
        }
    }

    inner class TheatreViewHolder(private val binding: CustomTheatreLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(theatre: Theatre_P) {
            //binding.
            //binding.homeScreenMoviePosterImage.setImageDrawable(R.drawable.pathaan_poster_portrait)
//            binding.root.setOnClickListener {
//                onNoteClicked(movie)
//            }
            binding.theatreName.text=theatre.name



            val theatreTimingAdapter : TheatreTimingAdapter = TheatreTimingAdapter(theatre.timing,
            theatre.name, binding.root.context)
//
        val theatreTimingLayoutManager = GridLayoutManager(binding.root.context, 3)
            binding.theatreTimingsRecyclerView.layoutManager = theatreTimingLayoutManager
            binding.theatreTimingsRecyclerView.adapter = theatreTimingAdapter
//
//        bi.recyclerViewTiming.layoutManager = theatreTimingLayoutManager
//        holder.recyclerViewTiming.adapter = theatreTimingAdapter


        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<Theatre_P>() {
        override fun areItemsTheSame(oldItem: Theatre_P, newItem: Theatre_P): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Theatre_P, newItem: Theatre_P): Boolean {
            return oldItem == newItem
        }
    }
}