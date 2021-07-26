package com.example.saveoassignment.utils

import com.example.saveoassignment.data.model.MoviesResponseItem
/*

Interface used for connecting both slider and movie recycler view data
 */
interface ItemClickListener {
    fun onItemClicked(moviesItem : MoviesResponseItem)

}