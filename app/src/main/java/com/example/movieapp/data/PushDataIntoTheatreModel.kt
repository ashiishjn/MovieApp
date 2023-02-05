package com.example.movieapp.data

import com.example.movieapp.model.CalendarModel
import com.example.movieapp.model.Theatre_P

class PushDataIntoTheatreModel {
    fun pushData() : ArrayList<Theatre_P> {
        val theatreArrayList : ArrayList<Theatre_P> = ArrayList()

        val timingArrayList : ArrayList<String> = ArrayList()
        timingArrayList.add("09:00 AM")
        timingArrayList.add("10:00 AM")
        timingArrayList.add("11:00 AM")
        timingArrayList.add("11:30 AM")
        timingArrayList.add("12:30 PM")
        timingArrayList.add("01:30 PM")
//        timingArrayList.add("02:30 PM")
//        timingArrayList.add("03:30 PM")
//        timingArrayList.add("04:30 PM")
//        timingArrayList.add("05:30 PM")
//        timingArrayList.add("06:30 PM")
//        timingArrayList.add("07:30 PM")
//        timingArrayList.add("08:30 PM")

        theatreArrayList.add(Theatre_P("PVR1", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR2", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR3", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR4", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR5", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR6", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR7", timingArrayList))
        theatreArrayList.add(Theatre_P("PVR8", timingArrayList))

        return theatreArrayList
    }
}