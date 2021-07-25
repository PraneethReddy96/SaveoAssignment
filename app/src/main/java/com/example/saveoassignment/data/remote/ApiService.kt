package com.example.saveoassignment.data.remote


import com.example.saveoassignment.data.model.MoviesResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /*
    suspend function used with @GET annotation on the end points, so that the function suspends
    until the response is fetched.
    */
    @GET("/shows")
    suspend fun getDetails(@Query("page") key: Int): MutableList<MoviesResponseItem?>?


}