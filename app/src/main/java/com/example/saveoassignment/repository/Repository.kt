package com.example.saveoassignment.repository


import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.data.remote.ApiService

class Repository {

    val apiClient = RetrofitGenerator.getInstance().create(ApiService::class.java)
    val requestHandler = RetrofitNetworkRequestHandler.ResponseHandler()


    /*
    This function fetches the api response and handles the response through the RequestHelperClass,
     returning a checked response to the user
      */
    suspend fun getMoviesItemList(key: Int): RetrofitNetworkRequestHandler.Resource<MutableList<MoviesResponseItem>> {

        var response = apiClient.getDetails(key)


        try {
            return requestHandler.handleSuccess(response!!)
        } catch (e: Exception) {

            return requestHandler.handleException(e)
        }

    }


}