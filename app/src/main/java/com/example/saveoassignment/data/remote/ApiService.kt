package com.example.saveoassignment.data.remote

import com.example.saveoassignment.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/shows")
    suspend  fun getDetails(@Query("page") key: Int): MutableList<MoviesResponse?>


}