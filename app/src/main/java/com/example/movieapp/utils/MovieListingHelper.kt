package com.example.movieapp.utils

import com.example.movieapp.model.MovieListingResponse
import com.example.movieapp.model.Theatre_P

class MovieListingHelper {

    fun ListToOrganisedList(MovieListingList:List<MovieListingResponse>):List<Theatre_P>{
        val res : ArrayList<Theatre_P> = ArrayList()
        //res.add()
        for(itr in MovieListingList)
        {
            var flag = 0
          for(itr1 in res)
          {
              if(itr.theatre.equals(itr1.name)) {
                  flag = 1
                  itr1.timing.add(itr.timimg)
              }//if already present in list


          }
          if(flag == 0) {
              val list: ArrayList<String> = ArrayList()
              list.add(itr.timimg)
              res.add(Theatre_P(itr.theatre, list))
          }
        }

        return res
    }
}