package com.example.movieapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.databinding.FragmentSeatsSelectionBinding
import com.example.movieapp.adapter.SeatLayoutAdapter
import kotlin.random.Random

class SeatSelectionView {

    fun workWithListener(view : View, binding : FragmentSeatsSelectionBinding) {

        val bullet = "&#8226"
        binding.theatreDetails.text = Constants.date + " " + "${Html.fromHtml(bullet, 0)}" + " " +
        Constants.theatre_name + " " + "${Html.fromHtml(bullet, 0)}" + " " + Constants.timing

        val seatList : ArrayList<String> = addSeats()
        val seatListSelected : ArrayList<Boolean> = addSeatsSelected()

        val seatLayoutAdapter : SeatLayoutAdapter =
            SeatLayoutAdapter(seatList, seatListSelected, view.context, binding)

        val layoutManager = GridLayoutManager(view.context, 6)

        binding.seatRecyclerView.layoutManager = layoutManager;
        binding.seatRecyclerView.adapter = seatLayoutAdapter;

        binding.purchaseTicketsButton.setOnClickListener {
            Toast.makeText(view.context, "Congrats! Your booking is successful.",
                Toast.LENGTH_SHORT).show()
            Constants.seat_selected = seatLayoutAdapter.seatSelectedList.joinToString(", ")
            notificationBuilder(view)
            view.findNavController().navigate(R.id.action_seatsSelection_to_confirmationScreenFragment)
        }

        binding.seatSelectionBackArrow.setOnClickListener {
            view.findNavController().navigate(R.id.action_seatsSelection_to_theatreSelection)
        }
    }

    private fun addSeats() : ArrayList<String> {
        val seatList : ArrayList<String> = ArrayList()
        for (i in 0 .. 47) {
            seatList.add(('A' + i / 6).toString() + ((i % 6)+1).toString())
        }
        return seatList
    }

    private fun addSeatsSelected() : ArrayList<Boolean> {
        val seatListSelected : ArrayList<Boolean> = ArrayList()
        for (i in 0 .. 47) {
            if(Random.nextInt(0,3) == 0 )
                seatListSelected.add(true)
            else
                seatListSelected.add(false)
        }
        return seatListSelected
    }

    private fun notificationBuilder(view: View) {

        val bullet = "&#8226"

        val notification_details =
                  Constants.movie_name + " " + "${Html.fromHtml(bullet, 0)}" + " " +
                        Constants.date + " " + "${Html.fromHtml(bullet, 0)}" + " " +
                Constants.theatre_name + " " + "${Html.fromHtml(bullet, 0)}" + " " + Constants.timing

        val builder = NotificationCompat.Builder(view.context, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle("Congrats! Your booking is successful.")
//            .setContentText(notification_details + "\nSeats Selected : " + seatDetails)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("$notification_details\nSeats Selected : ${Constants.seat_selected}"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManagerCompat : NotificationManagerCompat = NotificationManagerCompat.from(view.context)
        if (ActivityCompat.checkSelfPermission(
                view.context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notificationManagerCompat.notify(Constants.NOTIFICATION_ID, builder.build())
    }
}