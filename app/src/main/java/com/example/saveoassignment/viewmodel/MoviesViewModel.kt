package com.example.saveoassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.repository.Repository
import kotlinx.coroutines.Dispatchers

class MoviesViewModel(val repository : Repository) : ViewModel() {


    /*
     This function takes in the response from the repository class and converts it into live data
      and emits it back to the subscriber
      */
    fun getMoviesList(key: Int): LiveData<MutableList<MoviesResponseItem?>?>{


        return liveData(Dispatchers.IO) {

            val response = repository.getMoviesItemList(key)

            emit(response.data)

        }

    }



}