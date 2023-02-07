package com.example.movieapp.ui

import android.view.View
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.data.Constants
import com.example.movieapp.databinding.FragmentConfirmationScreenBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder


class ConfirmationScreenView {

    fun workWithListener(view : View, binding : FragmentConfirmationScreenBinding) {

        binding.confirmationMovieName.text = "Movie Name : " + Constants.movie_name
        binding.confirmationMovieTheatre.text ="Theatre : " + Constants.theatre_name
        binding.confirmationMovieDate.text = "Date : " + Constants.date
        binding.confirmationMovieTime.text = "Time : " + Constants.timing
        binding.confirmationMovieSeat.text = "Seat Selected : " + Constants.seat_selected
        binding.confirmationId.text = "Transaction ID : " + java.util.UUID.randomUUID().toString().substring(0, 12)

        generateQR(binding)

        binding.confirmationHomeScreenButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_confirmationScreenFragment_to_homeScreen)
        }

    }

    fun generateQR(binding : FragmentConfirmationScreenBinding) {

        val qr_text : String = binding.confirmationId.text.toString() +
                "\nMovie Name : " + Constants.movie_name +
                "\nTheatre : " + Constants.theatre_name +
                "\nDate : " + Constants.date +
                "\nTime : " + Constants.timing +
                "\nSeat Selected : " + Constants.seat_selected

        val multiFormatWriter : MultiFormatWriter = MultiFormatWriter()
        try {
            val matrix: BitMatrix = multiFormatWriter.encode(qr_text, BarcodeFormat.QR_CODE, 600, 600)
            val encoder = BarcodeEncoder()
            val bitmap = encoder.createBitmap(matrix)
            //set data image to imageview
            binding.confirmationQrCode.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }
}