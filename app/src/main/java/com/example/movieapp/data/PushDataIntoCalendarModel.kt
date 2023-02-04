package com.example.movieapp.data

import com.example.movieapp.model.CalendarModel
import java.util.*
import kotlin.collections.ArrayList

class PushDataIntoCalendarModel {

    fun pushData() : ArrayList<CalendarModel> {
        val cal = Calendar.getInstance()

        val calendarArrayList : ArrayList<CalendarModel> = ArrayList()

        for (i in 1..7){
            calendarArrayList.add(CalendarModel(geDay(cal[Calendar.DAY_OF_WEEK]),
                cal[Calendar.DATE].toString(), geMonth(cal[Calendar.MONTH])))
            cal.add(Calendar.DAY_OF_MONTH, 1)
        }
        return calendarArrayList
    }

    fun geDay(day: Int) : String{
        return when  {
            day == 1 -> "SUN"
            day == 2 -> "MON"
            day == 3 -> "TUE"
            day == 4 -> "WED"
            day == 5 -> "THU"
            day == 6 -> "FRI"
            else -> "SAT"
        }
    }

    fun geMonth(month: Int) : String{
        return when  {
            month == 0 -> "JAN"
            month == 1 -> "FEB"
            month == 2 -> "MAR"
            month == 3 -> "APR"
            month == 4 -> "MAY"
            month == 5 -> "JUN"
            month == 6 -> "JUL"
            month == 7 -> "AUG"
            month == 8 -> "SEP"
            month == 9 -> "OCT"
            month == 10 -> "NOV"
            else -> "DEC"
        }
    }
}